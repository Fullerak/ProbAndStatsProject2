import java.math.BigDecimal;
import java.math.BigInteger;

public class StatsLibrary {

	StatsLibrary(){
		
	}
	public BigInteger combination(int n, int r) {
		//creating statsLib so I can call the fact method
		StatsLibrary test = new StatsLibrary();
		
		//assigning the numerator to n!
		BigInteger numerator = test.factorial(n);
		
		//subtracting n - r first to get x
		int x = n - r;
		
		//getting the fact of x
		BigInteger xFact = test.factorial(x);
		
		//assigning r factorial in the denom
		BigInteger rFact = test.factorial(r);
		
		//multiply rFact * xFact to get the denom
		BigInteger denominator = rFact.multiply(xFact);
		
		//dividing the numerator and denominator for ans
		BigInteger ans = numerator.divide(denominator);
		
		//returning the answer
		return ans;
	}
	
	public BigInteger factorial(int num) {
		
		BigInteger init = new BigInteger("1");
		
		for (int i = 2; i <= num;++i) {
			
			init = init.multiply(BigInteger.valueOf(i));
			
		}
				
		return init;
	}

	public BigInteger hyperGeo(int N, int n, int r) {
		StatsLibrary test = new StatsLibrary();
		
		BigInteger num = test.combination(n, r).multiply(test.combination(N-n, r));
		BigInteger denom = test.combination(N, r);
		
		return num.divide(denom);
	}
	
	public double tchebysheffThm(int k) {
		double ans = (1-1/Math.pow(k, 2));
		return ans;
	}
	
	public BigInteger poissonDist(int lambda, int x) {
		StatsLibrary test = new StatsLibrary();
		
		double e = 2.718;
		double calc = Math.pow(e, lambda);
		BigDecimal b = BigDecimal.valueOf(calc);
		BigInteger c = b.toBigInteger();
		double calc2 =  Math.pow(lambda, x);
		BigDecimal d = BigDecimal.valueOf(calc2);
		BigInteger f = d.toBigInteger();
		BigInteger num = f.multiply(c);
		BigInteger denom = test.factorial(x);
		
		return num.divide(denom);
	}
	
	
}
