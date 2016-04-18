package ics314;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simpleical {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
            int usrInput=0;
            Scanner input = new Scanner(System.in);;
            String str = "";
            ArrayList<String> list = new ArrayList<String>();
            System.out.println("Would you like to enter files using arguments?  enter 1: \n "
                + " Or would you like to automaticallly add files?  enter 2: ");
            while(true){
                str = input.nextLine();
                    if (!str.equals("1")&& !str.equals("2")){
                        System.out.println("Please enter 1 or 2");
                    }
                    else {break;}                        
                } 
            if(str.equals("1")){
                for (int i = 0; i < args.length; i++){
                    list.add(args[i]);
                }
            } 
            else{
                System.out.println("Please enter number of event files: ");
            while(true){   
                if(input.hasNextInt()){   
                    usrInput = input.nextInt();
                if(1 <= usrInput)
                    break;
                else
                    continue;
                }
                input.nextLine();  //Comsume the garbage value
                    System.out.println("Enter an integer greater than 0:");
                }               
                for(int i=1; i<= usrInput;i++){
                    list.add(i+".ics");
                }
            }
                input.close();
		TimeSort.startsort(list);
	}

	public static String userinter() throws IOException {
		String filename = "", tstartdate = "", tstarttime = "", tstart = "", tenddate = "", tendtime = "", tend = "", msg = "", gpslat = "", gpslong = "", clas = "";
		int test = 1, conttest = 1, ascii = 0;
		Scanner input = new Scanner(System.in);

		System.out.println("Enter File Name:");
		filename = input.nextLine() + ".ics";
		// tstart inputs
		while (test == 1) {
			conttest = 1;
			System.out
					.println("Enter Start date in yearmonthdate format, ex. 20160218:");
			tstartdate = input.nextLine();
			if (tstartdate.length() == 8) {
				test = 0;
			} else {
				test = 1;
				conttest = 0;
				System.out.println("Invalid length");
			}
			if (conttest == 1) {
				int[] chartest = new int[tstartdate.length()];
				for (int i = 0; i < tstartdate.length(); i++) {
					ascii = (int) tstartdate.charAt(i);
					if (ascii >= 48 && ascii <= 57) {
						chartest[i] = 1;
					} else {
						chartest[i] = 0;
					}
				}
				for (int i = 0; i < tstartdate.length(); i++) {
					if (chartest[i] == 0) {
						System.out.println("Invalid char at position " + i);
						test = 1;
					}
				}
			}

		}
		test = 1;
		while (test == 1) {
			conttest = 1;
			System.out
					.println("Enter Start time in 6 digit military time format, ex. 210000:");
			tstarttime = input.nextLine();
			if (tstarttime.length() == 6) {
				test = 0;
			} else {
				test = 1;
				conttest = 0;
				System.out.println("Invalid length");
			}
			if (conttest == 1) {
				int[] chartest = new int[tstarttime.length()];
				for (int i = 0; i < tstarttime.length(); i++) {
					ascii = (int) tstarttime.charAt(i);
					if (ascii >= 48 && ascii <= 57) {
						chartest[i] = 1;
					} else {
						chartest[i] = 0;
					}
				}
				for (int i = 0; i < tstarttime.length(); i++) {
					if (chartest[i] == 0) {
						System.out.println("Invalid char at position " + i
								+ ", must be number 0-9");
						test = 1;
						conttest = 0;
					}
				}
				if (conttest == 1) {
					int x = Integer.parseInt(tstarttime);
					if (x < 0 || x > 245959) {
						System.out
								.println("Invalid time, value must be between 0 and 245959");
						test = 1;
					}
				}
			}
		}
		tstart = tstartdate + "T" + tstarttime;
		test = 1;
		conttest = 1;

		// tend inputs
		while (test == 1) {
			conttest = 1;
			System.out
					.println("Enter End date in yearmonthdate format, ex. 20160218:");
			tenddate = input.nextLine();
			if (tenddate.length() == 8) {
				test = 0;
			} else {
				test = 1;
				conttest = 0;
				System.out.println("Invalid length");
			}
			if (conttest == 1) {
				int[] chartest = new int[tenddate.length()];
				for (int i = 0; i < tenddate.length(); i++) {
					ascii = (int) tenddate.charAt(i);
					if (ascii >= 48 && ascii <= 57) {
						chartest[i] = 1;
					} else {
						chartest[i] = 0;
					}
				}
				for (int i = 0; i < tenddate.length(); i++) {
					if (chartest[i] == 0) {
						System.out.println("Invalid char at position " + i);
						test = 1;
					}
				}
			}
		}
		test = 1;
		while (test == 1) {
			conttest = 1;
			System.out
					.println("Enter End time in 6 digit military time format, ex. 210000:");
			tendtime = input.nextLine();
			if (tendtime.length() == 6) {
				test = 0;
			} else {
				test = 1;
				conttest = 0;
				System.out.println("Invalid length");
			}
			if (conttest == 1) {
				int[] chartest = new int[tendtime.length()];
				for (int i = 0; i < tendtime.length(); i++) {
					ascii = (int) tendtime.charAt(i);
					if (ascii >= 48 && ascii <= 57) {
						chartest[i] = 1;
					} else {
						chartest[i] = 0;
					}
				}
				for (int i = 0; i < tendtime.length(); i++) {
					if (chartest[i] == 0) {
						System.out.println("Invalid char at position " + i
								+ ", must be number 0-9");
						test = 1;
						conttest = 0;
					}
				}
			}
			if (conttest == 1) {
				int x = Integer.parseInt(tendtime);
				if (x < 0 || x > 245959) {
					System.out
							.println("Invalid time, value must be between 0 and 245959");
					test = 1;
				} else {
					test = 0;
				}
			}
		}
		tend = tenddate + "T" + tendtime;
		test = 1;
		// GPS latitude inputs
		while (test == 1) {
			conttest = 1;
			System.out
					.println("Enter GPS latitude if applicable, leave blank if not, ex. 37.386013 :");
			gpslat = input.nextLine();
			if (gpslat.equals("")) {
				conttest = 0;
				test = 0;
			}
			if (conttest == 1) {
				int[] chartest = new int[gpslat.length()];
				for (int i = 0; i < gpslat.length(); i++) {
					if (i != 2 || i != 3 || i != 4 || i != 0) {
						if ((int) gpslat.charAt(i) >= 48
								&& (int) gpslat.charAt(i) <= 57) {
							chartest[i] = 1;
						} else {
							chartest[i] = 0;
						}
					}
					if (i == 2 || i == 3 || i == 4) {
						if (((int) gpslat.charAt(i) >= 48 && (int) gpslat
								.charAt(i) <= 57)
								|| (int) gpslat.charAt(i) == 46) {
							chartest[i] = 1;
						} else {
							chartest[i] = 0;
						}
					}
					if (i == 0) {
						if (((int) gpslat.charAt(i) >= 48 && (int) gpslat
								.charAt(i) <= 57)
								|| (int) gpslat.charAt(i) == 45) {
							chartest[i] = 1;
						} else {
							chartest[i] = 0;
						}
					}
				}
				for (int i = 0; i < gpslat.length(); i++) {
					if (chartest[i] == 0) {
						System.out.println("Invalid char at position " + i);
						test = 1;
						conttest = 0;
					}
				}
			}
			if (conttest == 1) {
				float x = Float.parseFloat(gpslat);
				if (x < -90 || x > 90) {
					System.out
							.println("Invalid latitude, value must be between -90 and 90");
					test = 1;
				} else {
					test = 0;
				}
			}
		}
		test = 1;
		// GPS Longitude inputs
		while (test == 1) {
			conttest = 1;
			System.out
					.println("Enter GPS longitude if applicable, leave blank if not, ex. 37.386013 :");
			gpslong = input.nextLine();
			if (gpslat.equals("")) {
				conttest = 0;
				test = 0;
			}
			if (conttest == 1) {
				int[] chartest = new int[gpslong.length()];
				for (int i = 0; i < gpslong.length(); i++) {
					if (i != 2 || i != 3 || i != 4 || i != 0) {
						if ((int) gpslong.charAt(i) >= 48
								&& (int) gpslong.charAt(i) <= 57) {
							chartest[i] = 1;
						} else {
							chartest[i] = 0;
						}
					}
					if (i == 2 || i == 3 || i == 4) {
						if (((int) gpslong.charAt(i) >= 48 && (int) gpslong
								.charAt(i) <= 57)
								|| (int) gpslong.charAt(i) == 46) {
							chartest[i] = 1;
						} else {
							chartest[i] = 0;
						}
					}
					if (i == 0) {
						if (((int) gpslong.charAt(i) >= 48 && (int) gpslong
								.charAt(i) <= 57)
								|| (int) gpslong.charAt(i) == 45) {
							chartest[i] = 1;
						} else {
							chartest[i] = 0;
						}
					}
				}
				for (int i = 0; i < gpslong.length(); i++) {
					if (chartest[i] == 0) {
						System.out.println("Invalid char at position " + i);
						test = 1;
						conttest = 0;
					}
				}
			}
			if (conttest == 1) {
				float x = Float.parseFloat(gpslong);
				if (x < 0 || x > 180) {
					System.out
							.println("Invalid longitude, value must be between 0 and 180");
					test = 1;
				} else {
					test = 0;
				}
			}
		}
		test = 1;
		conttest = 1;
		while (test == 1) {
			System.out
					.println("Enter class of event, (PUBLIC, PRIVATE, CONFIDENTIAL):");
			clas = input.nextLine();
			if (clas.equals("PUBLIC") || clas.equals("PRIVATE")
					|| clas.equals("CONFIDENTIAL")) {
				test = 0;
			} else {
				System.out
						.println("Input must be PUBLIC, PRIVATE, or CONFIDENTIAL, case sensitive");
				test = 1;
			}
		}
		System.out.println("Enter Message:");
		msg = input.nextLine();

		createics(filename, tstart, tend, msg, gpslat, gpslong, clas);
		return filename;
	}

	private static void createics(String name, String start, String end,
			String msg, String gpsla, String gpslo, String clas)
			throws IOException {
		FileWriter write = new FileWriter(name);

		write.write("BEGIN:VCALENDAR" + '\n'
				+ "PRODID:-//Google Inc//Google Calendar 70.9054//EN" + '\n'
				+ "VERSION:2.0" + '\n' + "CALSCALE:GREGORIAN" + '\n'
				+ "METHOD:PUBLISH" + '\n' + "X-WR-CALyNAME:");
		write.write((name + '\n'));
		write.write("X-WR-TIMEZONE:Pacific/Honolulu\nBEGIN:VEVENT\nDTSTART:");
		write.write((start + '\n'));
		write.write("DTEND:");
		write.write((end + '\n'));
		write.write("GEO:");
		write.write((gpsla + ";" + gpslo + '\n'));
		write.write("CLASS:");
		write.write((clas + '\n'));
		write.write("UID:tccsg6j6deenb9gr61l0h7gcas@google.com\nDESCRIPTION:\nLOCATION:\nSEQUENCE:3\nSTATUS:CONFIRMED\nSUMMARY:");
		write.write((msg + '\n'));
		write.write("TRANSP:OPAQUE\nEND:VEVENT\nEND:VCALENDAR\n");

		write.close();
	}
}
