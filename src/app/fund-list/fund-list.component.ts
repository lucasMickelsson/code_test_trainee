// fund-list.component.ts

import { Component, OnInit } from '@angular/core';
import { FundService } from '../fund.service';
import { HttpResponse } from '@angular/common/http';

export interface Fund {
  instrumentId: string;
  isin: string;
  fundName: string;
  fundType: string;
  estimationDate: number;
  rate: number;
  change1y: number;
  currency: string;
  availableForMonthlySaving: boolean;
  redemptionMinFee: { amount: number; currency: string; empty: boolean };
  redemptionPercent: number | null;
  subscriptionMinFee: { amount: number; currency: string; empty: boolean };
  subscriptionPercent: number | null;
  subscriptionMinValue: { amount: number; currency: string; empty: boolean };
  investmentClass: any; // Change 'any' to the specific type if available
  permissions: {
    allowedToBuy: boolean;
    allowedToSell: boolean;
    allowedToSwap: boolean;
    allowedForWatchlist: boolean;
    allowedForDetailedInformation: boolean;
    allowedToTrade: boolean;
  };
  buyCommissions: any; // Change 'any' to the specific type if available
  sellCommissions: any; // Change 'any' to the specific type if available
  change1m: number;
  change3m: number;
  change3y: number;
  minimumCommission: any; // Change 'any' to the specific type if available
  technicalCommission: any; // Change 'any' to the specific type if available
  technicalCommissionUp: any; // Change 'any' to the specific type if available
  sellCommission: any; // Change 'any' to the specific type if available
  administrativeFee: number;
  startDate: number;
  yearHigh: number;
  yearLow: number;
  graphImageLink: string | null;
  documents: { url: string; title: string }[];
  fundCompany: string;
  startValue: number;
  closePrice: number;
  latestClosePriceDate: number;
  countDecimals: number;
}

export interface FundResponse {
  status: {
    success: boolean;
    errors: any[];
    infos: any[];
    jSessionId: string;
  };
  data: Fund[];
}

@Component({
  selector: 'app-fund-list',
  templateUrl: './fund-list.component.html',
  styleUrls: ['./fund-list.component.css']
})
export class FundListComponent implements OnInit {
  funds: Fund[] | null = null;

  constructor(private fundService: FundService) { }

  ngOnInit(): void {
    this.fundService.getFunds().subscribe(response => {
      console.log(response); // Check the response in the console
      this.funds = (response as any)[0]?.data || [];
    });
  }
}
