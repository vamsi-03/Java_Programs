import java.util.*;
public class Prim
{
	int prim(int n,int cost[][],int src,int tree[][])
	{
	
		int i,j,k,u,v,min,sum;
		int d[]=new int[10];
		int s[]=new int[10];
		int path[]=new int[10];
		
		for(i=0;i<n;i++)
		{
			d[i]=cost[src][i];
			s[i]=0;
			path[i]=src;
		}
		
		s[src]=1;
		k=0;
		sum=0;
		
		for(i=1;i<n;i++)
		{
			min=999;
			u=-1;
			for(j=0;j<n;j++)
			{
				if(s[j]==0)
				{
				
					if(d[j]<=min)
					{
					
						min=d[j];
						u=j;
					}
					
				}
			}
			
			tree[k][0]=u;
			tree[k][1]=path[u];
			k++;
			sum=sum+cost[u][path[u]];
			s[u]=1;
			
			for(v=0;v<n;v++)
			{
				if(s[v]==0 && cost[u][v]<d[v])
				{
					d[v]=cost[u][v];
					path[v]=u;
				
				}
			
			}
		
		
		}
		return sum;
	
	
	}
	
	public static void main(String args[])
	{
	
		Prim p=new Prim();
		int cost[][]=new int[10][10];
		int tree[][]=new int[10][10];
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the no. of nodes:");
		int n=sc.nextInt();
		System.out.println("Enter the cost adjacency matrix:");
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				cost[i][j]=sc.nextInt();
		int min=999;
		int src=0;
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(cost[i][j]!=0 && cost[i][j]<min)
				{
					min=cost[i][j];
					src=i;
				}
				
		int sum=p.prim(n,cost,src,tree);
		if(sum>=999)
		{
			System.out.println("Spanning tree does not exist");
			System.exit(0);
		
		}
		
		System.out.println("The Spanning tree is shown below");
		for(int i=0;i<n-1;i++)
			System.out.println(tree[i][0]+","+tree[i][1]);
		System.out.println("The sum of spanning tree is:"+sum);
	} 
}
