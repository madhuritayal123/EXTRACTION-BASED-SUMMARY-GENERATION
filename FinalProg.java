import java.io.*;

class FinalProg
{
	public static void main(String args[])throws IOException
	{
		String searchFor, data = "", ans = "", match = "", str;
		int flag = 0;
		int choice=4;
		System.out.println("Extractive Summarization");
		System.out.println();
		System.out.println("1:-Key-word based Summarization");
		System.out.println("2:-Title based Summarization");
		System.out.println("3:-Position based Summarization");
		System.out.println("4:-Cue Word based Summarization");
		System.out.println();
		System.out.println("Enter your choice from 1-4");
//		Scanner s = new Scanner(System.in);
//		choice = s.nextInt();
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		choice = Integer.parseInt(b.readLine());
		switch(choice)

		{

		case 1://Key-word based Summarization

		FileInputStream fis = new FileInputStream("Test.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));

		FileOutputStream fos = new FileOutputStream("Test1.txt");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

	    str = br.readLine();
	    while((str = br.readLine()) != null)
	    	data = data + str;
	    br.close();
//	    System.out.println(data);

	    char ch[] = data.toCharArray();
        System.out.println("Enter the keyword on which summary is  to be created");
 	    searchFor = input.readLine();

 	    for(int i = 0; i < ch.length; i++)
 	    {
			ans = ans + ch[i];
			if(ch[i] != ' ' && ch[i] != '.')
			{
				match = match + ch[i];
			}
			if(ch[i] == ' ' || ch[i] == '.')
			{
				if(match.equalsIgnoreCase(searchFor))
					flag = 1;
				match = "";
				if(ch[i] == '.')
				{
					if(flag == 1)
						bw.write(ans, 0, ans.length());
					ans = "";
					flag = 0;
				}
			}
		}
		bw.close();
		break;

		case 2:// Title based summarization
			fis = new FileInputStream("Test.txt");
			 br = new BufferedReader(new InputStreamReader(fis));

					 fos = new FileOutputStream("Test1.txt");
					 bw = new BufferedWriter(new OutputStreamWriter(fos));

					 input = new BufferedReader(new InputStreamReader(System.in));

				    str = br.readLine();
				    String str1 = "";
				    data = "";
				    while((str1 = br.readLine()) != null)
				    	data = data + str1;
				    br.close();

				//System.out.println(data);

				    ch = data.toCharArray();
			       // System.out.println("Enter the keyword on which summary is  to be created");
			 	    searchFor = str;

			 	    for(int i = 0; i < ch.length; i++)
			 	    {
						ans = ans + ch[i];
						if(ch[i] != ' ' && ch[i] != '.')
						{
							match = match + ch[i];
						}
						if(ch[i] == ' ' || ch[i] == '.')
						{
							if(match.equalsIgnoreCase(searchFor))
								flag = 1;
							match = "";
							if(ch[i] == '.')
							{
								if(flag == 1)
									bw.write(ans, 0, ans.length());
								ans = "";
								flag = 0;
							}
						}
					}
		bw.close();
		break;

		case 3:// position based summarization
					fis = new FileInputStream("Test.txt");
					 br = new BufferedReader(new InputStreamReader(fis));

							 fos = new FileOutputStream("Test1.txt");
							 bw = new BufferedWriter(new OutputStreamWriter(fos));

							 input = new BufferedReader(new InputStreamReader(System.in));

						    str = br.readLine();
						    str1 = "";
						    data = "";
						    int count = 0;
						    while((str1 = br.readLine()) != null)
						    	data = data + str1;
						    br.close();

					//	    System.out.println(data);

						    ch = data.toCharArray();
					       // System.out.println("Enter the keyword on which summary is  to be created");
					 	    searchFor = str;

					 	    for(int i = 0; i < ch.length; i++)
					 	    {
								ans = ans + ch[i];
								if(ch[i] != ' ' && ch[i] != '.')
								{
									match = match + ch[i];
								}
								if(ch[i] == ' ' || ch[i] == '.')
								{
									if(match.equalsIgnoreCase(searchFor))
										flag = 1;
									match = "";
									if(ch[i] == '.')
									{
										count++;
										if(count == 4)
											break;
										if(flag == 1)
											bw.write(ans, 0, ans.length());
										ans = "";
										flag = 0;
									}
								}
							}
							ans = "";
							count = 0;
							for(int i = ch.length - 2;i > 0; i--)
							{
								ans = ans + ch[i];
									if(ch[i] != ' ' && ch[i] != '.')
									{
											match = match + ch[i];
									}
									if(ch[i] == ' ' || ch[i] == '.')
									{
											StringBuffer Match = new StringBuffer(match);
											StringBuffer sb = Match.reverse();
											match = new String(Match);
															//		System.out.println(match);

												if(match.equalsIgnoreCase(searchFor))
												flag = 1;
												match = "";
												if(ch[i] == '.')
												{
															count++;
															if(count == 4)
																break;
																if(flag == 1)
																		{
																			Match = new StringBuffer(ans);
																			sb = Match.reverse();
																			ans = sb.substring(1, sb.length()) + ".";

																			bw.write(ans, 0, ans.length());
																		}
																		ans = "";
																		flag = 0;
																	}
								}
							}
		bw.close();
		break;

		case 4://for cue-words
				fis = new FileInputStream("Test.txt");
				br = new BufferedReader(new InputStreamReader(fis));

				fos = new FileOutputStream("Test1.txt");
				bw = new BufferedWriter(new OutputStreamWriter(fos));

				input = new BufferedReader(new InputStreamReader(System.in));

			    while((str = br.readLine()) != null)
			    	data = data + str;
			    br.close();
		//	    System.out.println(data);

			    ch = data.toCharArray();
		//        System.out.println("Enter the keyword on which summary is  to be created");
		 	    searchFor = "conclusion";
		 	    String searchFor1 = "According";

		 	    for(int i = 0; i < ch.length; i++)
		 	    {
					ans = ans + ch[i];
					if(ch[i] != ' ' && ch[i] != '.')
					{
						match = match + ch[i];
					}
					if(ch[i] == ' ' || ch[i] == '.')
					{
						if(match.equalsIgnoreCase(searchFor) || match.equalsIgnoreCase(searchFor1))
							flag = 1;
						match = "";
						if(ch[i] == '.')
						{
							if(flag == 1)
								bw.write(ans, 0, ans.length());
							ans = "";
							flag = 0;
						}
					}
				}
				bw.close();
		break;


	}
}
}