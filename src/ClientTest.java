/**
@author LIG SYSTEM
@class Name : ClientTest.java
@page  아이디/비밀번호 찾기
@date 2013. 3. 12.
@version 1.0
@brief
 ClientTest.java :: Description
    - AXIS 웹서비스 조회 테스트용 클라이언트
    - 

    - 개정이력(Modification Information)
            수정일                  수정자            수정내용
      -----------   --------   ---------------------------
      2013. 3. 12.   c.m.you         최초 생성

@param *

@todo TODO
*/
package webservice.MedicinesInfoWS;

import java.io.File;
import java.io.RandomAccessFile;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

import javax.activation.DataHandler;
import javax.xml.rpc.ServiceException;

public class ClientTest {

	public static void main(String[] args) {

		String gubun = "";	
		String file1 = "download/standardcode.txt";
		String file2 = "download/medicineinfo.txt";
		String file3 = "download/principalingredientinfo.txt";
		String file4 = "download/newitemstdcd.txt";

		try
		{
			
				gubun = args[0];				

				ClientTest ct = new ClientTest();
					  
			  //-------------new !! ---------------
				if(gubun.equals("1")){
					
					//조회일 기준 최종자료 조회
					ct.getStandardCode();
						
				}else if(gubun.equals("2")){
				
					//조회일 기준 최종자료 다운로드
					ct.getStandardCodeFile(file1);
											
				}else if(gubun.equals("3")){
					
					//조회구간에 공고된 자료 조회
					ct.getNewItemStdCd();	
					
				}else if(gubun.equals("4")){
					
					//조회구간에 공고된 자료 다운로드
					ct.getNewItemStdCdFile(file4);
					
				}else if(gubun.equals("5")){
					
					//생산·수입·공급 중단 의약품 자료 조회
					ct.getNoProductInfo(args[1], args[2]);	//20121002 20121102	 
					
				}else if(gubun.equals("6")){
				
					//생산·수입·공급 중단 의약품 자료 다운로드 
					ct.getNoProductInfoFile(args[1], args[2]);	//20121002 20121002	
					
				}else if(gubun.equals("7")){
					
					//조회일 기준전.전공고일 이후 희귀·생동·퇴장방지 자료 조회
					ct.getRareStdCd(args[1]);	//20120720		
					
				}else if(gubun.equals("8")){
					
					//조회일 기준전.전공고일 이후 희귀·생동·퇴장방지 자료 다운로드  
					ct.getRareStdCdFile(args[1]);	//20120720						
					
				}else if(gubun.equals("9")){
				
					//요양기관정보조회
					ct.retriveYkihoInfo(args[1]);	//"1139600600" 덕산병원			
					
				}else if(gubun.equals("10")){
				
					//RFID Tag 정보 조회
					ct.retriveRfidTagInfo(args[1], args[2]); 	//8806636054002 RFID-001	
					
				}
				
				
		}catch(ArrayIndexOutOfBoundsException ae){
		
					System.out.println("######################################################");
					System.out.println("#                                                    #");
					System.out.println("#  필요한 입력값이 모두  입력되지 않았습니다.        		 #");
					System.out.println("#  ex) 실행구분번호, 조회시작일, 조회종료일          		 #");
					System.out.println("#                                                    #");
					System.out.println("######################################################");
					
		} 
		catch(Exception e){
			e.printStackTrace();	
		}		
	  
	}//end main
	
		
	
	/* 생산·수입·공급 중단 의약품 정보 조회   
	 * param : 조회시작일, 조회종료일
	 * 
	 * */
	public void getNoProductInfo(String startDate, String endDate) {

		MedicineInfoWSIFServiceLocator locator = new MedicineInfoWSIFServiceLocator();
		MedicineInfoWSIF service = null;
		NoProductInfoVO[] entities = null;			

		try {	

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String dateTime = df.format(new Date());

			service = locator.getMedicinesInfoWS();
			entities = service.getNoProductInfo(startDate, endDate);

			System.out.println("##########################################################");
		    System.out.println("## " + dateTime + "생산·수입·공급 중단 의약품 정보 조회" +" ##");
			System.out.println("##########################################################");

			int count = 0;

			if(entities != null){

				if(entities.length>0){				

					for (int i=0;i<entities.length;i++ ) {
						count = i+1;

						NoProductInfoVO result = entities[i];
					
						if(result != null){	
						
							System.out.println("\n");
							System.out.println("*********************************************");
							System.out.println("공고일자 : "+result.getS_field1());	//공고일자
							System.out.println("표준코드 : "+result.getS_field2());	//표준코드
							System.out.println("제품명 : "+result.getS_field3());	//제품명
							System.out.println("업체명 : "+result.getS_field4());	//업체명
							System.out.println("약품규격 : "+result.getS_field5());	//약품규격
							System.out.println("전문일반구분명 : "+result.getS_field6());	//전문일반구분명
							System.out.println("제조수입구분명 : "+result.getS_field7());	//제조수입구분명
							System.out.println("요양급여비용청구코드 : "+result.getS_field8());	//요양급여비용청구코드
												          
						}
					}
					
					System.out.println("\n\n####[총건수 ]##### : "+entities.length);
					
				}else{
					System.out.println("생산·수입·공급 중단 의약품 정보 없음.");
				}
			
			}else{

				System.out.println("생산·수입·공급 중단 의약품 정보 없음..");

			}
			System.out.println("\n");
			
			
		} catch (ServiceException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		} catch (RemoteException re) {
			// TODO Auto-generated catch block
			re.printStackTrace();
		}			
	}			
	
	
	
	/* 생산.수입.공급 중단된 의약품정보를  다운로드  
	 * param : 조회시작일, 조회종료일
	 * 
	 * */
	public void getNoProductInfoFile(String startDate, String endDate) {

		MedicineInfoWSIFServiceLocator locator = new MedicineInfoWSIFServiceLocator();
		MedicineInfoWSIF service = null;
		NoProductInfoVO[] entities = null;			

		try {	
						
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String dateTime = df.format(new Date());
			service = locator.getMedicinesInfoWS();
			
			System.out.println("##########################################################");
		    System.out.println("## " + dateTime + "생산·수입·공급 중단 의약품 정보 다운로드" +" ##");
			System.out.println("##########################################################");
			
			String file = "c:/temp/NoProductInfoFile"+ dateTime+".txt";
			
			DataHandler dh = service.getNoProductInfoFile(startDate, endDate);
			System.out.println((dh.getDataSource()).getName());
			FileOutputStream fos = new FileOutputStream(file);
			dh.writeTo(fos);
	        fos.flush();
						
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}			
	
		
	
	/* 희귀·생동·퇴장방지 의약품정보 조회   
	 * param : 조회일
	 * 
	 * */
	public void getRareStdCd(String rtDt) {

		MedicineInfoWSIFServiceLocator locator = new MedicineInfoWSIFServiceLocator();
		MedicineInfoWSIF service = null;
		ItemStdCdVO[] entities = null;			

		try {	

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String dateTime = df.format(new Date());

			service = locator.getMedicinesInfoWS();
			entities = service.getRareStdCd(rtDt);

			System.out.println("##########################################################");
		    System.out.println("## " + dateTime + "희귀·생동·퇴장방지 의약품정보 조회" +" ##");
			System.out.println("##########################################################");

			int count = 0;

			if(entities != null){

				if(entities.length>0){				

					for (int i=0;i<entities.length;i++ ) {
						count = i+1;

						ItemStdCdVO result = entities[i];
					
						if(result != null){	
						
							System.out.println("\n");
							System.out.println("*********************************************");
							System.out.println("업체명: "+result.getUser_nm());
							System.out.println("한글상품명: "+result.getKor_mgds_nm());
							System.out.println("포장내제품충수량: "+result.getPack_mgds_tot_qty());
							System.out.println("약품규격: "+result.getMedc_nom());
				            System.out.println("약품단위: "+result.getMedc_unit());
				            System.out.println("제형구분: "+result.getGb_cd_type());
				            System.out.println("품목기준코드: "+result.getItem_std_cd());
				            System.out.println("전문일반구분: "+result.getSpc_gnl_nm());
				            System.out.println("대표코드: "+result.getRepr_cd());
							System.out.println("표준코드: "+result.getStd_cd());
							System.out.println("부여여부: "+result.getDecsn_yn());
							System.out.println("제품코드: "+result.getMgds_cd());
				            System.out.println("일반명코드: "+result.getGnl_nm_cd());
				            System.out.println("환산규격: "+result.getConvert_qty());
				            System.out.println("비고: "+result.getRmk());
				            							          
						}
					}
					
					System.out.println("\n\n####[총건수 ]##### : "+entities.length);
					
				}else{
					System.out.println("희귀·생동·퇴장방지 의약품정보 없음.");
				}
			
			}else{

				System.out.println("희귀·생동·퇴장방지 의약품정보 없음..");

			}
			System.out.println("\n");
			
			
		} catch (ServiceException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		} catch (RemoteException re) {
			// TODO Auto-generated catch block
			re.printStackTrace();
		}			
	}			
	
	

	/* 희귀.생동,퇴장방지 중단된 의약품정보 자료를 다운로드
	 * param : 조회일
	 * 
	 * */
	public void getRareStdCdFile(String rtDt) {

		MedicineInfoWSIFServiceLocator locator = new MedicineInfoWSIFServiceLocator();
		MedicineInfoWSIF service = null;
		ItemStdCdVO[] entities = null;			

		try {	

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String dateTime = df.format(new Date());

			service = locator.getMedicinesInfoWS();
			
			System.out.println("##########################################################");
		    System.out.println("## " + dateTime + "희귀·생동·퇴장방지 의약품정보 다운로드" +" ##");
			System.out.println("##########################################################");

			String file = "c:/temp/RareStdCdFile"+ dateTime+".txt";
			
			DataHandler dh = service.getRareStdCdFile(rtDt);
			System.out.println((dh.getDataSource()).getName());
			FileOutputStream fos = new FileOutputStream(file);
			dh.writeTo(fos);
	        fos.flush();
			
			
			
		}  catch(Exception e) {
			e.printStackTrace();
		}
		
	}			
	
		
		/* 요양기관정보 조회   
		 * param : 사업자번호
		 * 
		 * */
		public void retriveYkihoInfo(String cNo) {

		MedicineInfoWSIFServiceLocator locator = new MedicineInfoWSIFServiceLocator();
		MedicineInfoWSIF service = null;
		YoyangInfoVO[] entities = null;			

		try {	

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String dateTime = df.format(new Date());

			service = locator.getMedicinesInfoWS();
			entities = service.retriveYkihoInfo(cNo);

			System.out.println("###########################################");
		    System.out.println("## " + dateTime + " 요양기관 정보 조회" +" ##");
			System.out.println("###########################################");

			int count = 0;

			if(entities != null){

				if(entities.length>0){				

					for (int i=0;i<entities.length;i++ ) {
						count = i+1;

						YoyangInfoVO result = entities[i];
					
						if(result != null){	
						
							System.out.println("\n");
							System.out.println("*********************************************");
							System.out.println("요양기관명 : "+result.getS_field1());	//요양기관명
							System.out.println("사업자등록번호 : "+result.getS_field2());		//사업자등록번호
							System.out.println("요양기관기호 : "+result.getS_field3());	//요양기관기호
							System.out.println("대표자명 : "+result.getS_field4());	//대표자명
							System.out.println("소재지 : "+result.getS_field5());	//소재지
							System.out.println("현재개설일자 : "+result.getS_field6());	//현재개설일자
							System.out.println("현재폐업일자 : "+result.getS_field7());		//현재폐업일자
							System.out.println("직전개설일자 : "+result.getS_field8());		//직전개설일자
							System.out.println("직전폐업일자 : "+result.getS_field9());		//직전폐업일자
					          
						}
					}
					
					System.out.println("\n\n####[총건수 ]##### : "+entities.length);
					
				}else{
					System.out.println("업데이트 된 요양기관 정보 없음.");
				}
			
			}else{

				System.out.println("업데이트 된  요양기관 정보 없음..");

			}
			System.out.println("\n");
			
			
		} catch (ServiceException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		} catch (RemoteException re) {
			// TODO Auto-generated catch block
			re.printStackTrace();
		}			
	}	

		
		/* Rfid Tag 정보 조회   
		 * param : 표준코드(10자리), 일련번호(최대 20자리)
		 * 
		 * */
		public void retriveRfidTagInfo(String stdCode, String seqNo) {

			MedicineInfoWSIFServiceLocator locator = new MedicineInfoWSIFServiceLocator();
			MedicineInfoWSIF service = null;
			RfidTagInfoVO[] entities = null;			
	
			try {	
	
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String dateTime = df.format(new Date());
	
				service = locator.getMedicinesInfoWS();
				entities = service.retriveRfidTagInfo(stdCode, seqNo);
	
				System.out.println("###########################################");
			    System.out.println("## " + dateTime + " Rfid Tag정보 조회" +" ##");
				System.out.println("###########################################");
	
				int count = 0;
	
				if(entities != null){
	
					if(entities.length>0){				
	
						for (int i=0;i<entities.length;i++ ) {
							count = i+1;
	
							RfidTagInfoVO result = entities[i];
						
							if(result != null){	
							
								System.out.println("\n");
								System.out.println("*********************************************");
								System.out.println("표준코드 : "+result.getS_field1());	//표준코드
								System.out.println("표준코드명 : "+result.getS_field2());	//표준코드명
								System.out.println("로트번호 : "+result.getS_field3());	//로트번호
								System.out.println("RFID 일련번호 : "+result.getS_field4());	//RFID 일련번호
								System.out.println("유통기간 : "+result.getS_field5());	//유통기간
													          
							}
						}
						
						System.out.println("\n\n####[총건수 ]##### : "+entities.length);
						
					}else{
						System.out.println("Rfid Tag 정보 없음.");
					}
				
				}else{
	
					System.out.println("Rfid Tag 정보 없음..");
	
				}
				System.out.println("\n");
				
				
			} catch (ServiceException se) {
				// TODO Auto-generated catch block
				se.printStackTrace();
			} catch (RemoteException re) {
				// TODO Auto-generated catch block
				re.printStackTrace();
			}			
		}		
		
	
	
	public void getNewItemStdCdFile(String fileName) {
		
		MedicineInfoWSIFServiceLocator locator = new MedicineInfoWSIFServiceLocator();
		MedicineInfoWSIF service = null;
		
		try {	
			service = locator.getMedicinesInfoWS();
			DataHandler dh = service.getNewItemStdCdFile("20091101","20091201");
			FileOutputStream fos = new FileOutputStream(fileName);
			dh.writeTo(fos);
	        fos.flush();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	


	public void getNewItemStdCd() {

		MedicineInfoWSIFServiceLocator locator = new MedicineInfoWSIFServiceLocator();
		MedicineInfoWSIF service = null;
		ItemStdCdVO[] entities = null;			

		try {	

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String dateTime = df.format(new Date());

			service = locator.getMedicinesInfoWS();
			entities = service.getNewItemStdCd("20081110","20081120");

			System.out.println("#################################################################");
		    System.out.println("## " + dateTime + " 업데이트 된 표준 코드 매핑 정보 시작");
			System.out.println("");

			int count = 0;

			if(entities != null){

				if(entities.length>0){				

					for (int i=0;i<entities.length;i++ ) {
						count = i+1;

						ItemStdCdVO result = entities[i];
					
						if(result != null){	
						
							  System.out.println("표준코드: "+result.getStd_cd());
					          System.out.println("한글상품명: "+result.getKor_mgds_nm());
					          System.out.println("대표코드: "+result.getRepr_cd());
					          System.out.println("제형구분: "+result.getGb_cd_type());
					          System.out.println("약품규격: "+result.getMedc_nom());
					          System.out.println("약품단위: "+result.getMedc_unit());
					          System.out.println("포장내제품충수량: "+result.getPack_mgds_tot_qty());					          					           										
					          System.out.println("환산규격: "+result.getConvert_qty());
					          System.out.println("부여여부: "+result.getDecsn_yn());
					          System.out.println("일반명코드: "+result.getGnl_nm_cd());
					          System.out.println("품목허가일자: "+result.getItem_perm_dt());
					          System.out.println("품목기준코드: "+result.getItem_std_cd());
					          System.out.println("제품코드: "+result.getMgds_cd());
					          System.out.println("비고: "+result.getRmk());
					          System.out.println("전문일반구분: "+result.getSpc_gnl_nm());					          
					          System.out.println("업체명: "+result.getUser_nm());
					          System.out.println("약품구분: "+result.getMedc_type());
					          System.out.println("포장형태: "+result.getPack_type());
					          System.out.println("포장내단품수량: "+result.getPack_sgl_mgds_qty());					          
					          System.out.println("최초입력일: "+result.getFst_in_dt());
							  System.out.println("최종수정일: "+result.getLast_upd_dt());
							
						}
					}

				}else{
					System.out.println("업데이트 된 표준 코드 매핑 정보 없음");
				}
			
			}else{

				System.out.println("업데이트 된 표준 코드 매핑 정보 없음");

			}
			System.out.println("");
			System.out.println("#################################################################");
			
			
		} catch (ServiceException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		} catch (RemoteException re) {
			// TODO Auto-generated catch block
			re.printStackTrace();
		}			
	}	
	
	
	public void getStandardCodeFile(String file) {
		try {	
			MedicineInfoWSIFServiceLocator locator = new MedicineInfoWSIFServiceLocator();
			MedicineInfoWSIF service = null;

			service = locator.getMedicinesInfoWS();

			DataHandler dh = service.retriveFileOfStandardCode();
			System.out.println((dh.getDataSource()).getName());
			FileOutputStream fos = new FileOutputStream(file);
			dh.writeTo(fos);
	        fos.flush();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void getMedicineInfoFile(String file) {
		try {	
			MedicineInfoWSIFServiceLocator locator = new MedicineInfoWSIFServiceLocator();
			MedicineInfoWSIF service = null;

			service = locator.getMedicinesInfoWS();

			DataHandler dh = service.retriveFileOfMedicineInfo();
			System.out.println((dh.getDataSource()).getName());
			FileOutputStream fos = new FileOutputStream(file);
			dh.writeTo(fos);
			fos.flush();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void getPrincipalIngredientInfoFile(String file) {
		try {	
			MedicineInfoWSIFServiceLocator locator = new MedicineInfoWSIFServiceLocator();
			MedicineInfoWSIF service = null;

			service = locator.getMedicinesInfoWS();

			DataHandler dh = service.retriveFileOfPrincipalIngredientInfo();
			System.out.println((dh.getDataSource()).getName());
			FileOutputStream fos = new FileOutputStream(file);
			dh.writeTo(fos);
	        fos.flush();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}	

	public void getStandardCode() {
		try {	

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String dateTime = df.format(new Date());

			MedicineInfoWSIFServiceLocator locator = new MedicineInfoWSIFServiceLocator();
			MedicineInfoWSIF service = null;
			MedicineInfoVO[] entities = null;			
			service = locator.getMedicinesInfoWS();
			entities = service.retriveStandardCode();

			System.out.println("#################################################################");
		    System.out.println("## " + dateTime + " getStandardCode 매핑 정보 시작");
			System.out.println("");

			int count = 0;

			if(entities != null){

				if(entities.length>0){				

					for (int i=0;i<entities.length;i++ ) {
						count = i+1;

						MedicineInfoVO result = entities[i];
					
						if(result != null){	
							System.out.println("번호 : " + count);
							System.out.println("표준코드 : " + result.getStd_cd());
							System.out.println("한글상품명 : " + result.getKor_mgds_nm());
							System.out.println("영문상품명 : " + result.getEng_mgds_nm());
							System.out.println("총수량 : " + result.getPack_sgl_mgds_qty());
							System.out.println("대표코드 : " + result.getRepr_cd());
							System.out.println("품목기준코드 : " + result.getItem_std_cd());
							System.out.println("EDI코드 : " + result.getMgds_cd());
							System.out.println("구바코드 : " + result.getBc());
							System.out.println("업체코드 : " + result.getEntp_cd());
							System.out.println("------------------------------------------------------------");
							
						}
					}

				}else{
					System.out.println("업데이트 된 표준 코드 매핑 정보 없음.");
				}
			
			}else{

				System.out.println("업데이트 된 표준 코드 매핑 정보 없음,,");

			}
			System.out.println("");
			System.out.println("#################################################################");
			
			
		} catch (ServiceException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		} catch (RemoteException re) {
			// TODO Auto-generated catch block
			re.printStackTrace();
		}			
	}

	public void deleteTransFile() {
		try {
			File file = new File("C:/tmp");
			File[] files = file.listFiles();
			String name;

			for(int i=0; i<files.length; i++) {
				name = files[i].getName();
			    if(name.toLowerCase().endsWith(".txt")) {
				    files[i].delete();
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writeLog(String strLog) {
	  	SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
	  	SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	  	String fileDate = sdf1.format(new java.util.Date());
	  	String writeDate = sdf2.format(new java.util.Date());
 	
	  	RandomAccessFile raf = null;
		try {
	  		File f = new File("C:/temp/standardcode_"+fileDate+".txt");
			if(!f.exists()) {
				f.createNewFile();
			}
			raf = new RandomAccessFile(f, "rw");
			raf.seek(raf.length());
			raf.writeBytes(writeDate+"=== "+strLog+"\r\n");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {if(raf!=null) raf.close();} catch(Exception e) {}
		}
	}	
	

}
