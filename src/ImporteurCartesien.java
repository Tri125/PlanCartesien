

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ImporteurCartesien 
{
	private BufferedReader in = null;
	private List<PointDouble> points;
	private PointDouble axeX;
	private PointDouble axeY;
	
	public ImporteurCartesien()
	{
		points = new ArrayList<PointDouble>();
	}
	
	
	public List<PointDouble> getDerniereImportation()
	{
		return points;
	}
	
	public PointDouble getAxeX()
	{
		return axeX;
	}
	
	public PointDouble getAxeY()
	{
		return axeY;
	}
	
	
	public void Chargement(String chemin)
	{
		try 
		{
			String ligne;
			int nbrLigne = 0;
			int nbrPoints = 0;
			
			in = new BufferedReader(new InputStreamReader(new FileInputStream(chemin), "UTF-8"));
			
			while ( (ligne = in.readLine()) != null)
			{
				String ligneTraite = ligne.trim();
				
				if(ligneTraite.isEmpty() || ligneTraite.charAt(0) == '#' )
				{
					//Continue
				}
				else
				{
					if (nbrLigne == 0)
					{
						nbrPoints = Integer.parseInt(ligneTraite);
					}
					else
					{
						if (nbrLigne != nbrPoints+1)
						{
							String x;
							String y;
							double nbrX;
							double nbrY;
							
							char[] tmp = ligneTraite.toCharArray();
							String stringTmp = ligneTraite;
							for (int i = 0; i < tmp.length; i++)
							{
								if (tmp[i] == ' ')
								{
									x = stringTmp.substring(0, i);
									y = stringTmp.substring(i).trim();
									nbrX = Double.parseDouble(x);
									nbrY = Double.parseDouble(y);
									points.add(new PointDouble(nbrX, nbrY));
									break;
								}
							}
						}
						else
						{
							String x = null;
							String y = null;
							String x2 = null;
							String y2 = null;
							double nbrX;
							double nbrY;
							
							char[] tmp = ligneTraite.toCharArray();
							String stringTmp = ligneTraite;
							for (int i = 0; i < tmp.length; i++)
							{
								if (tmp[i] == ' ')
								{
									x = stringTmp.substring(0, i);
									stringTmp = stringTmp.substring(i).trim();
									tmp = stringTmp.toCharArray();
									break;
								}
							}
							
							for (int j = 0; j < stringTmp.length(); j++)
							{
								if (tmp[j] == ' ')
								{
									y = stringTmp.substring(0, j);
									stringTmp = stringTmp.substring(j).trim();
									tmp = stringTmp.toCharArray();
									break;
								}
							}
							
							for (int j = 0; j < stringTmp.length(); j++)
							{
								if (tmp[j] == ' ')
								{
									x2 = stringTmp.substring(0, j);
									stringTmp = stringTmp.substring(j).trim();
									y2 = stringTmp;
									break;
								}
							}
							
							nbrX = Double.parseDouble(x);
							nbrY = Double.parseDouble(y);
							this.axeX = new PointDouble(nbrX, nbrY);
							nbrX = Double.parseDouble(x2);
							nbrY = Double.parseDouble(y2);
							this.axeY = new PointDouble(nbrX, nbrY);
						}
					}
				}
				nbrLigne++;
			}
			in.close();
		}
		
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
