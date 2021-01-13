package net.torrypubrepo.ecomdashboard.Controller;

import net.torrypubrepo.ecomdashboard.DataModel.BranchMonthlyTransaction;
import net.torrypubrepo.ecomdashboard.DataModel.BranchMonthly_TransactionSample;
import net.torrypubrepo.ecomdashboard.DataModel.BranchOffices;
import net.torrypubrepo.ecomdashboard.Interfaces.Branch_MetaData;
import net.torrypubrepo.ecomdashboard.Services.BranchReport_ServiceImpl;
import net.torrypubrepo.ecomdashboard.Services.Branch_Monthly_Transaction_ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

/*
 Created by Toriola Nov
 */
@Controller
public class BranchController implements Branch_MetaData
{
    @Autowired
    BranchReport_ServiceImpl branchReport_service;
    @Autowired
    Branch_Monthly_Transaction_ServiceImpl branch_monthly_transaction_service;

    @GetMapping(value={"/branches"})
    public String dashHome(Model model) {
        Map<String, Long> chartData = branch_monthly_transaction_service.getTotalTransactionByMonths();

        // Bar Chart Data UI Data
        List<String> labelMonths = Arrays.asList(BranchMonthly_TransactionSample.MONTH_OF_YEAR.clone());

        // Online Revenue Data
        List<Integer> onlineRevenue = Arrays.asList(10000000, 12700000, 11650000, 10645278, 13647890, 11782465,
                13465980, 14278409, 13645893, 13800354, 14899234, 15678098, 16983992);

        // Model for Chart Data
        StringBuilder chartDataValue = new StringBuilder();
        StringBuilder chartLabel = new StringBuilder();
        StringBuilder sYearValues = new StringBuilder();

        // Create each month Data in the order of labelMonths
        for (int i = 0; i < labelMonths.size(); i++) {
            String month = labelMonths.get(i);
            chartDataValue.append(chartData.get(month));
            chartLabel.append(month);
            sYearValues.append(onlineRevenue.get(i));
            if (i < labelMonths.size() - 1) {
                chartDataValue.append(",");
                chartLabel.append(",");
                sYearValues.append(",");
            }
        }

        // Online Monthly Chart
        //List<String> onlineYears = Arrays.asList("2007", "2008", "2009", "2010", "2011", "2012",
        //      "2013", "2014", "2015", "2016", "2017", "2018", "2019");
        //StringBuilder sYears = new StringBuilder();

        String monthLabels = chartLabel.toString();
        // Bar Chart Data
        model.addAttribute("chartLabel", monthLabels);
        model.addAttribute("chartData", chartDataValue.toString());

        // Line Chart Data
        model.addAttribute("onlineYear", monthLabels);
        model.addAttribute("onlineRevenue", sYearValues.toString());

        // Branch Matrix UI Data
        // Outstanding Branches
        List<String> outstandingBranches = new ArrayList<>();
        // Successful Branches
        List<String> successfulBranches = new ArrayList<>();
        // Warning Branches
        List<String> warnedBranches = new ArrayList<>();
        // Poor Branches
        List<String> poorBranches = new ArrayList<>();

        List<BranchOffices> allBranches = branchReport_service.getAllBranches();
        for (BranchOffices branchOffice : allBranches) {
            int target = branchOffice.getTargetProfit();
            int actual = branchOffice.getActualProfit();
            int diff = actual - target;

            if (diff >= 5)
                outstandingBranches.add(branchOffice.getBranchId());
            else if (diff >= 2)
                successfulBranches.add(branchOffice.getBranchId());
            else if (diff >= 1)
                warnedBranches.add(branchOffice.getBranchId());
            else
                poorBranches.add(branchOffice.getBranchId());

        }//End for

        // Branch Matrix Board UI Data
        model.addAttribute("bestBranch", outstandingBranches);
        model.addAttribute("betterBranch", successfulBranches);
        model.addAttribute("goodBranch", warnedBranches);
        model.addAttribute("poorBranch", poorBranches);


        // For All Branches Table
        model.addAttribute("branches", allBranches);

        return "branchonlyreport";
    }

    @GetMapping(value={"/branches/branch"})
    public String branchDashboard(@RequestParam(value = "Id") String Id, Model model)
    {

        // Bar Chart Data UI Data
        List<String> labelMonths = Arrays.asList(BranchMonthly_TransactionSample.MONTH_OF_YEAR.clone());

        // Online Revenue Data
        List<BranchMonthlyTransaction> monthlyTransactions =
                branch_monthly_transaction_service.getTransactionByBranchId(Id);
        // Convert to Map
        Map<String, BranchMonthlyTransaction> monthlySalesPerBranch = new HashMap<>();

        monthlyTransactions.forEach(b -> monthlySalesPerBranch.put(b.getSalesMonth(), b));

        // Model for Chart Data
        StringBuilder chartDataValue = new StringBuilder();
        StringBuilder chartLabel = new StringBuilder();
        StringBuilder sMonth = new StringBuilder();

        // Create each month Data in the order of labelMonths
        for (int i = 0; i < labelMonths.size(); i++)
        {
            String month = labelMonths.get(i);
            chartDataValue.append(monthlySalesPerBranch.get(month).getActualSales());
            chartLabel.append(month);

            // Sort Branch Monthly Tabular Data
            if (i < labelMonths.size() - 1)
            {
                chartDataValue.append(",");
                chartLabel.append(",");
                sMonth.append(",");
            }
        }//End for

        String monthLabels = chartLabel.toString();
        // Bar Chart Data
        model.addAttribute("chartLabel", monthLabels);
        model.addAttribute("chartData", chartDataValue.toString());

        // Branch Matrix UI Data
        // Outstanding Branches
        List<String> outstandingBranches = new ArrayList<>();
        // Successful Branches
        List<String> successfulBranches = new ArrayList<>();
        // Warning Branches
        List<String> warnedBranches = new ArrayList<>();
        // Poor Branches
        List<String> poorBranches = new ArrayList<>();

        //monthlyTransactions; //branchReport_service.getAllBranches();

        // Find the Branch Performance Matrix
        for (BranchMonthlyTransaction branchOffice : monthlyTransactions)
        {
            long target = branchOffice.getTargetSales();
            long actual = branchOffice.getActualSales();
            long diff =actual - target;

            if (diff >= BEST_TARGET_VALUE)
                outstandingBranches.add(branchOffice.getSalesMonth());
            else if (diff >= BETTER_TARGET_VALUE)
                successfulBranches.add(branchOffice.getSalesMonth());
            else if (diff >=GOOD_TARGET_VALUE)
                warnedBranches.add(branchOffice.getSalesMonth());
            else if (diff < POOR_TARGET_VALUE)
                poorBranches.add(branchOffice.getSalesMonth());
            else
                poorBranches.add(branchOffice.getSalesMonth());

        }//End for

        //System.out.println(" Monthly Transaction Per BranchId "+branch_monthly_transaction_service.getTransactionByBranchId("Ecom595"));

        // Branch Matrix Board UI Data
        model.addAttribute("bestBranch", outstandingBranches);
        model.addAttribute("betterBranch", successfulBranches);
        model.addAttribute("goodBranch", warnedBranches);
        model.addAttribute("poorBranch", poorBranches);

        // Store Location
        model.addAttribute("location", monthlyTransactions.get(0).getBranchLocation());
        // For All Branches Table
        // System.out.println(monthlyTransactions.toString());
        model.addAttribute("bchmonth", monthlyTransactions);

        return "branchonlyreport";
    }//End branchDashboard

}//End class
