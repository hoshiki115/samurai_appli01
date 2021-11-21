package model;

import java.io.Serializable;

public class InputCost implements Serializable {
    
    private String monthlyCost; // 毎月必ず発生する費用
    private String everyYearCost; // 毎年必ず発生する費用
    private String timeLimitCost1; // 期限付きで毎年発生する費用１
    private String timeLimitAge1; // 期限付きで毎年発生する費用１の年齢
    private String timeLimitCost2; // 期限付きで毎年発生する費用２
    private String timeLimitAge2; // 期限付きで毎年発生する費用２の年齢
    private String expectedCost; // 期限付きで予定する費用
    private String expectedAge; // 期限付きで予定する費用の年齢
    private String planCostF; // 毎年予定する費用
    
    public InputCost() {}
    public InputCost(String monthlyCost, String everyYearCost, String timeLimitCost1, 
            String timeLimitAge1, String timeLimitCost2, String timeLimitAge2,
            String expectedCost, String expectedAge, String planCostF) {
        this.monthlyCost = monthlyCost;
        this.everyYearCost = everyYearCost;
        this.timeLimitCost1 = timeLimitCost1;
        this.timeLimitAge1 = timeLimitAge1;
        this.timeLimitCost2 = timeLimitCost2;
        this.timeLimitAge2 = timeLimitAge2;
        this.expectedCost = expectedCost;
        this.expectedAge = expectedAge;
        this.planCostF = planCostF;
    }
    
    public String getMonthlyCost() { return monthlyCost; }
    public String getEveryYearCost() { return everyYearCost; }
    public String getTimeLimitCost1() { return timeLimitCost1; }
    public String getTimeLimitAge1() { return timeLimitAge1; }
    public String getTimeLimitCost2() { return timeLimitCost2; }
    public String getTimeLimitAge2() { return timeLimitAge2; }
    public String getExpectedCost() { return expectedCost; }
    public String getExpectedAge() { return expectedAge; }
    public String getPlanCostF() { return planCostF; }
}
