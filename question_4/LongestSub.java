// Code in Java to find the longest repeating subsequence

import java.io.*;
import java.util.*;

class longest
{
	static int LongestRepeatingSubseq(String str)
	{
		int n = str.length();

		// Create and initialize DP table
		int[][] dp = new int[n+1][n+1];

		for (int i=1; i<=n; i++)
		{
			for (int j=1; j<=n; j++)
			{
				// If characters match and indexes are not same
				if (str.charAt(i-1) == str.charAt(j-1) && i!=j)
					dp[i][j] = 1 + dp[i-1][j-1];		
					
				// If characters do not match
				else
					dp[i][j] = max(dp[i][j-1], dp[i-1][j]);
			}
		}
		return dp[n][n];
	}

	static int max(int m, int n){
		if(m>n)
		return m;
		else 
		return n;
	}
	
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = sc.nextLine();
		System.out.println(LongestRepeatingSubseq(str));
	}
}