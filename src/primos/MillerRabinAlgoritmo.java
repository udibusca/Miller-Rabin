package primos;

import java.math.BigInteger;
import java.util.Random;

public class MillerRabinAlgoritmo {

	public boolean isPrimo(long numeroDigitado) {

		if (numeroDigitado == 0 || numeroDigitado == 1) {
			return false;	
		}

		if (numeroDigitado == 2) {
			return true;	
		}

		if (numeroDigitado % 2 == 0) {
			return false;
		}

		long s = numeroDigitado - 1;
		
		while (s % 2 == 0)
			   s /= 2;

		Random rand = new Random();

		for (int i = 0; i < 1000; i++) {
			
			long numeroRandon = Math.abs(rand.nextLong());
			long a = numeroRandon % (numeroDigitado - 1) + 1, temp = s;
			long mod = modPow(a, temp, numeroDigitado);
			
			while (temp != numeroDigitado - 1 && mod != 1 && mod != numeroDigitado - 1) {
				mod = mulMod(mod, mod, numeroDigitado);
				temp *= 2;
			}
			
			if (mod != numeroDigitado - 1 && temp % 2 == 0) {
				return false;
			}
		}
		return true;
	}

	/** Função para calcular(a ^ b) % c **/
	public long modPow(long a, long b, long c) {
		long res = 1;

		for (int i = 0; i < b; i++) {
			res *= a;
			res %= c;
		}
		return res % c;
	}


	public long mulMod(long a, long b, long mod) {
		
		/** Função para calcular (a * b) % c **/
		long res = BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).mod(BigInteger.valueOf(mod)).longValue();
		
		return res;
	}

}
