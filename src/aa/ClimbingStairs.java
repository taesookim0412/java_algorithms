package aa;

public class ClimbingStairs {
    int[] dp = new int[0];
    public int climbStairs(int n) {
        this.dp = new int[n+1];
        this.dp[1] = 1;
        if (this.dp.length > 2)
            this.dp[2] = 2;
        return this.helper(n);
    }

    public int helper(int n){
        if (n==1) return 1;
        if (n==2) return 2;
        if (dp[n] == 0){
            dp[n] = this.helper(n-1) + this.helper(n-2);
        }
        return dp[n];
    }
}
