
public class Tutorials {
	
	
	public static int decode(String message)
	{
		
		int msgLen = message.length();
		if(msgLen == 0 || msgLen == 1)
			return 1;
		
		int count = 0;
		
		if(message.charAt(msgLen - 1 ) > '0')
			count = decode(message.substring(0, msgLen - 1));
		
		
		if((message.charAt(msgLen - 2) < '2') || ( message.charAt(msgLen - 2) == '2' &&  message.charAt(msgLen - 1) < '7' ) )
			count += decode(message.substring(0, msgLen - 2));
		
		return count;
	}
	
	
	public static int decodeDp(String message)
	{
		int msgLen = message.length();
		int[] decodeCount = new int[msgLen + 1];
		
		decodeCount[0] =1;
		decodeCount[1] =1;
		
		
		for(int i=2; i< msgLen + 1; i++)
		{
			if(message.charAt(i - 1 ) > '0')
				decodeCount[i] = decodeCount[i-1];
			
			if((message.charAt(i - 2) < '2') || ( message.charAt(i - 2) == '2' &&  message.charAt(i - 1) < '7' ) )
				decodeCount[i] = decodeCount[i] + decodeCount[i-2];
		}
		
		return decodeCount[msgLen];
	}
	
	
	
	public static void main(String args[])
	{
		System.out.println(decodeDp("12321"));
	}

}
