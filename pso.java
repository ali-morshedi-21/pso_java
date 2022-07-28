package PSO;

public class pso 
{
	public static void main(String[] args) 
	{
		double r1,r2,w;
		double v , v_new;
		
		
		int n_population = 100;
		
		int x_min = 0 ; 
		int x_max = 1000;
		
		double x_g , x_i , x;
		x_g = Double.POSITIVE_INFINITY;
		
		int max_iteration = 10;
		int counter = 0;
		
		double all_x[] = new double[n_population];
		double all_x_best[] = new double[n_population];
		double all_v[] = new double[n_population];
		
		
		for(int i=0;i<n_population;i++) 
		{
			double rand = Math.random() * (x_max-x_min+1) + x_min;
			all_x[i] = rand;
			all_x_best[i] = rand;
			all_v[i] = Math.random()*10;
			
			if(func(all_x[i]) < func(x_g)) 
			{
				x_g = all_x[i];
			}
		}
		
		
		while(counter<max_iteration) 
		{
			for(int i=0;i<n_population;i++) 
			{
				r1 = Math.random();
				r2 = Math.random();
				w =	Math.random();
				
				v_new = w * all_v[i] + r1 * (all_x_best[i] - all_x[i]) + r2 * (x_g - all_x[i]);
					
				all_v[i] = v_new;
				
				all_x[i] = all_x[i] + all_v[i] ;
				
				if(func(all_x[i]) < func(all_x_best[i])) 
				{
					all_x_best[i] = all_x[i];
					
					if(func(all_x[i]) < func(x_g)) 
					{
						x_g =  all_x[i];
					}
				}
				
			}
			counter++;
		}
		
		System.out.println(x_g);
		
		System.out.println("**********************");
		
		for(int i = 0 ; i < n_population ; i++) 
		{
			System.out.println(all_x[i]);
		}
		
	}
	
	public static double func(double num) 
	{
		double y = Math.pow(num , 2); 
		
		return y;
	}
	
	public static boolean checkِDomain(double num , int min , int max) 
	{
		if(num > max || num < min) 
		{
			return false;
		}
		else {
			return true;
		}
	}
	
}












