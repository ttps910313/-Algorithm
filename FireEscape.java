import java.util.*;

class FireEscape
{
	//陣列列大小
	private static int arrRow = 3;
	//陣列行大小
	private static int arrCol = 4;
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		//宣告陣列
		int[][] arr = new int[arrRow][arrCol]; 
		
		//出口總數
		int numOfExit = sc.nextInt();        
		
		
		//初始化陣列為0
		for(int i = 0 ; i < arrRow ; i ++)
		{
			for(int j = 0 ; j < arrCol ; j ++)
			{
				arr[i][j] = 0;  
			}
		}

		//初始化陣列，讓陣列有權重
		for(int i  = 0 ; i < numOfExit ; i ++)
		{
			int[][] firstArr = new int[arrRow][arrCol];
			int exitRow = sc.nextInt();
			int exitCol = sc.nextInt();
			firstArr[exitRow][exitCol] = 100;
			for(int j = 0 ; j < arrRow ; j ++)
			{
				for(int k = 0 ; k < arrCol ; k ++)
				{
					int power = 10 * (Math.abs(exitRow - j) + Math.abs(exitCol - k));
					firstArr[j][k] = 100 - power;
				}
			}
			arr = firstStep(arr, firstArr);
			
		}
		
		for(int i = 0 ; i < arrRow ; i ++)
		{
			for(int j = 0 ; j < arrCol ; j ++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		
		//火災總數
		int numOfFire = sc.nextInt();
		
		for(int i = 0 ; i < numOfFire ; i ++)
		{
			int firePoint_r = sc.nextInt();
			int firePoint_c = sc.nextInt();
			arr = fireStep(arr, firePoint_r, firePoint_c);
		}
		
		for(int i = 0 ; i < arrRow ; i ++)
		{
			for(int j = 0 ; j < arrCol ; j ++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		//煙總數
		
		int numOfSmoke = sc.nextInt();
		for(int i = 0 ; i < numOfSmoke ; i ++)
		{
			int smokePoint_r = sc.nextInt();
			int smokePoint_c = sc.nextInt();
			arr = smokeStep(arr, smokePoint_r, smokePoint_c);
		}
		
		
		for(int i = 0 ; i < arrRow ; i ++)
		{
			for(int j = 0 ; j < arrCol ; j ++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	 
	private static int[][] firstStep(int[][] arr1, int[][] arr2)
	{
		for(int i = 0 ; i < arrRow ; i ++)
		{
			for(int j = 0 ; j < arrCol ; j ++)
			{
				if(arr1[i][j] < arr2[i][j])
				{
					int temp = arr1[i][j];
					arr1[i][j] = arr2[i][j];
					arr2[i][j] = temp;
				}
			}
		}
		return arr1;
	}
	
	private static int[][] fireStep(int[][] arr, int firePoint_r, int firePoint_c)
	{
		arr[firePoint_r][firePoint_c] = 0;

		if((firePoint_r - 1) >= 0 && ((firePoint_r - 1) < arrRow && (firePoint_r - 1) >= 0))
		{
			arr[firePoint_r - 1][firePoint_c] -= 10;
		}
		if((firePoint_c - 1) >= 0 && ((firePoint_c - 1) < arrCol && (firePoint_c - 1) >= 0))
		{
			arr[firePoint_r][firePoint_c - 1] -= 10;
		}
		if((firePoint_r + 1) <= arrRow && ((firePoint_r + 1) < arrRow && (firePoint_r + 1) >= 0))
		{
			arr[firePoint_r + 1][firePoint_c] -= 10;
		}
		if((firePoint_c + 1) <= arrCol && ((firePoint_c + 1) < arrCol && (firePoint_c + 1) >= 0))
		{
			arr[firePoint_r][firePoint_c + 1] -= 10;
		}
		
		for(int i = 0 ; i < arrRow ; i ++)
		{
			for(int j = 0 ; j < arrCol ; j ++)
			{
				if(arr[i][j] < 0)
				{
					arr[i][j] = 0;
				}
			}
		}
		
		
		return arr;
	}
	
	private static int[][] smokeStep(int[][] arr, int smokePoint_r, int smokePoint_c)
	{
		if((smokePoint_r - 1) >= 0 && ((smokePoint_r - 1) < arrRow && (smokePoint_r - 1) >= 0))
		{
			arr[smokePoint_r - 1][smokePoint_c] -= 10;
		}
		if((smokePoint_c - 1) >= 0 && ((smokePoint_c - 1) < arrCol && (smokePoint_c - 1) >= 0))
		{
			arr[smokePoint_r][smokePoint_c - 1] -= 10;
		}
		if((smokePoint_r + 1) <= arrRow && ((smokePoint_r + 1) < arrRow && (smokePoint_r + 1) >= 0))
		{
			arr[smokePoint_r + 1][smokePoint_c] -= 10;
		}
		if((smokePoint_c + 1) <= arrCol && ((smokePoint_c + 1) < arrCol && (smokePoint_c + 1) >= 0))
		{
			arr[smokePoint_r][smokePoint_c + 1] -= 10;
		}
		
		for(int i = 0 ; i < arrRow ; i ++)
		{
			for(int j = 0 ; j < arrCol ; j ++)
			{
				if(arr[i][j] < 0)
				{
					arr[i][j] = 0;
				}
			}
		}
		
		return arr;
	}
	
}