package com.artitech.tsalano.tukisha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class TandCActicity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tand_cacticity);


        textView=(TextView)findViewById(R.id.TNCtext);
        String para ="TERMS AND CONDITIONS RELATING TO THE TUKISHA PREPAID PRODUCTS “WE PAY REWARDS” MOBILE APPLICATION \n" +
                "\n"+
                "1.\tIMPORTANT NOTICE\n" +
                "1.1\tThese Terms and Conditions are binding and enforceable on every person that accesses and/or uses the Tukisha Prepaid Products Mobile Application (\"the We Pay Rewards Mobile Application\") (\"you\", \"your\" or \"user\"), including but not limited to users who are consumers for purposes of the Consumer Protection Act 68 of 2008 (the \"CPA\").\n" +
                "1.2\tThese Terms and Conditions contain provisions that appear in similar text and style to this clause and which -\n" +
                "1.2.1\tmay limit the risk or liability of Tukisha; and/or\n" +
                "1.2.2\tmay create risk or liability for the user; and/or\n" +
                "1.2.3\tmay compel the user to indemnify Tukisha; and/or\n" +
                "1.2.4\tserves as an acknowledgement, by the user, of a fact.\n" +
                "1.3\tYour attention is drawn to these Terms and Conditions because they are important and should be carefully noted.\n" +
                "1.4\tIf there is any provision in these Terms and Conditions that you do not understand, it is your responsibility to have the relevant provision/s explained to you (by sending your query to support@tukisha.co.za or support@wepayrewards.co.za ) before you accept the Terms and Conditions or continue using the Tukisha Mobile Application. Nothing in these Terms and Conditions is intended or must be understood to unlawfully restrict, limit or avoid any right or obligation, as the case may be, created for either you or Tukisha in terms of the CPA.\n" +
                "1.5\tTukisha permits the use of this We Pay Rewards Mobile Application subject to the Terms and Conditions. By using this Tukisha We Pay Rewards Mobile Application in any way, you shall be deemed to have irrevocably accepted all the Terms and Conditions unconditionally. You must not use the Tukisha We Pay Rewards Mobile Application if you do not agree to the Terms and Conditions. By downloading, installing or using this software or any portion thereof, you agree to the Terms and Conditions set out herein. \n" +
                "\n"+
                "2.\tINTRODUCTION\n" +
                "2.1\tThe Tukisha We Pay Rewards Mobile Application enables you to purchase prepaid tokens for various prepaid products, such as electricity, airtime, data and sms bundles.\n" +
                "2.2\tThese Terms and Conditions govern:\n" +
                "2.2.1\tall transactions relating to the prepaid products which are offered on the Tukisha Mobile Application; and\n" +
                "2.2.2\tthe use of the Tukisha Mobile Application.\n" +
                "2.3\tTukisha's Privacy Policy (incorporating its cookies policy) and Payment Security Policy form part of and must be read with these Terms and Conditions (\"collectively referred to herein as \"the Terms and Conditions\").\n" +
                "\n"+
                "3.\tREGISTRATION AND USE OF THE TUKISHA MOBILE APPLICATION\n" +
                "3.1\tThis agreement (\"this Agreement\") is entered between you (\"You\") and Tukisha (Pty) Limited (\"Tukisha\"). Subject to the terms and conditions of this Agreement, You are hereby granted the non-transferable right to use this software (\"Tukisha We Pay Rewards Mobile Application\") solely for personal, and commercial purposes.\n" +
                "3.2\tYou may not use the Tukisha We Pay Rewards Mobile Application in any manner that may impair, overburden, damage, disable or otherwise compromise or in any way interfere with - (i) Tukisha's services; (ii) any other party's use and enjoyment of Tukisha's services; (iii) the services and products of any third parties (including, without limitation, the Authorised Device). You agree to comply with all local laws and regulations governing the downloading, installation and/or use of the Tukisha Mobile Application, including, without limitation, any usage rules set forth in the online application store terms of service.\n" +
                "3.3\tFrom time to time, Tukisha may, in its discretion, automatically check the version of the Tukisha We Pay Rewards Mobile Application installed on the Authorised Device and, if applicable, provide updates or upgrades for the Tukisha We Pay Rewards Mobile Application (\"Updates\"). Updates may contain, without limitation, bug fixes, patches, enhanced functionality, plug-ins and new versions of the Tukisha Mobile Application. By installing the Tukisha Mobile Application, You authorise the automatic download and installation of Updates and agree to download and install Updates manually if necessary. Your use of the Tukisha We Pay Rewards Mobile Application and Updates will be governed by this Agreement (as amended by any terms and conditions that may be provided with Updates from time to time).\n" +
                "3.4\tTukisha reserves the right, in its discretion and at any time, to temporarily disable or permanently discontinue any and all functionality of the Tukisha We Pay Rewards Mobile Application without notice and with no liability, in any respect whatsoever, to you.\n" +
                "3.5\tFor the avoidance of doubt, this Agreement is solely between Tukisha and You.\n" +
                "3.6\tTo register as a user on the Tukisha We Pay Rewards Mobile Application, You must provide a unique email address and the system will auto generate a password for you which you can change at your discretion and provide certain information and personal details to Tukisha. You will need to use your unique email address and password to access the Tukisha We Pay Rewards Mobile Application to purchase the prepaid electricity services offered on such Mobile Application.\n" +
                "3.7\tYou agree and warrant that your username and password shall:\n" +
                "3.7.1\tbe used for Your personal use only; and\n" +
                "3.7.2\tnot be disclosed by You to any third party.\n" +
                "3.8\tFor security purposes You agree to enter the correct email address and password whenever buying prepaid products, failing which you will be denied access.\n" +
                "3.9\tYou agree that once the correct email address and password relating to your account has been entered, irrespective of whether the use of the email address and password is unauthorised or fraudulent, You will be liable for payment of such order.\n" +
                "3.10\tYou agree to notify Tukisha immediately upon becoming aware of or reasonably suspecting any unauthorised access to or use of Your username and password and to take steps to mitigate any resultant loss or harm.\n" +
                "3.11\tBy using the Tukisha We Pay Rewards Mobile Application you warrant that you are 18 (eighteen) years of age or older and of full legal capacity.\n" +
                "3.12\tYou may update, edit or terminate Your account at any time by sending an e-mail to support@tukisha.co.za or support@wepayrewards.co.za .\n" +
                "3.13\tTukisha may track and archive information regarding the use by You of the Tukisha We Pay Rewards Mobile Application (\"Use Information\"). Use Information does not reveal Your personal identity. Use Information may be stored and processed in the Republic of South Africa or any other country in which Tukisha or its agents maintain facilities. By using the Tukisha We Pay Rewards Mobile Application, You consent to the collection of Your User Information and to any transfer of Your User Information outside of Your country.\n" +
                "\n"+
                "4.\tPURCHASE PRICE OF TOKENS AND TRANSACTION FEES\n" +
                "4.1\tThe purchase of various prepaid products through the Tukisha We Pay Rewards Mobile Application is subject to any credit limitations or payment ceilings imposed by your bank and by the limits of Your device.\n" +
                "4.2\tThe price payable for the product for which the token is required shall be as set by the respective Service Provider of the relevant product. Due to the fixed service fees set by the Service Provider, the minimum transaction amount will be R10 For Eskom Prepaid Electricity, R20,00 for Unpin, R2.00 for Telco Products per transaction and the maximum transaction amount will be R5 000.00 per transaction.\n" +
                "4.3\tWe are committed to providing secure online and mobile payment facilities. All transactions are encrypted using appropriate encryption technology. \n" +
                "4.4\tAll prices shown on our Tukisha We Pay Rewards Mobile Application are quoted in South African Rands and are valid and effective only in the Republic of South Africa.\n" +
                "4.5\tPayment can be made for Trading Funds into your wallet account for prepaid electricity & Airtime services sold by Tukisha on the Tukisha We Pay Rewards Mobile Application via EFT, Branch Deposits and ATM Deposits only. You also warrant that your wallet Trading Funds are sufficient to cover all the costs incurred because of the services used on the Tukisha Mobile Application;\n" +
                "\n"+
                "5.\tREFUND POLICY\n" +
                "5.1\tTukisha will not process any refunds if the product token number has been generated or can be regenerated within 24 hours (in the case of a time out). You should contact the relevant Service Provider if Your device will not accept the token.\n" +
                "5.2\tDue to the consumable nature of the product, should You purchase any product in error or in excess of Your requirements, Tukisha shall be under no obligation to refund You or to reverse the transaction.\n" +
                "5.3\tIn the event that You do not receive Your product token number within 24 hours from the time that the transaction been paid for, you shall be entitled to a full refund on the condition that You notify Tukisha in writing [at support@tukisha.co.za and support@wepayrewards.co.za] within 24 hours thereafter that you have not received Your product token number. In the event that you fail to notify Tukisha within the aforesaid 48- hour time frame, you shall only be entitled to a refund if Tukisha is refunded by the relevant Service Provider. In such instance, Tukisha shall only be liable to refund You if its account has been credited with the relevant amounts from the Service Provider.\n" +
                "5.4\tTUKISHA reserves the right, at all times, to cancel (for any reason whatsoever) any transaction that takes place on the Tukisha We Pay Rewards Mobile Application. In such event, Tukisha shall be obliged to refund You in the relevant amount or to provide You with a credit token for the amount purchased by You.\n" +
                "\n"+
                "6.\tELECTRONIC COMMUNICATIONS\n" +
                "When you visit the Tukisha We Pay Rewards Mobile Application or send emails to us, you consent to receiving communications from us or any of our divisions or partners electronically in accordance with our privacy policy.\n" +
                "7.\tPROPRIETARY RIGHTS\n" +
                "7.1\tYou hereby acknowledge that Tukisha owns all rights, title and interest, of whatever nature, in and to the Tukisha We Pay Rewards Mobile Application and to any and all proprietary and confidential information contained therein (\"Tukisha Information\"). The Tukisha We Pay Rewards Mobile Application and Tukisha Information are, inter alia, protected by applicable intellectual property and other laws, including patent law, copyright law, trade secret law, trademark law, unfair competition law, and any and all other proprietary rights, and any and all applications, renewals, extensions and restorations thereof, now or hereafter in force and effect, worldwide and whether registered or not. You agree that You will not (and will not allow any third party to) (i) modify, adapt, translate, prepare derivative works from, decompile, reverse engineer or disassemble the Tukisha We Pay Rewards Mobile Application or otherwise attempt to derive source code from the Tukisha Mobile Application; (ii) copy, distribute, transfer, sell or license the Tukisha Mobile Application; (iii) transfer the Tukisha We Pay Rewards Mobile Application to, or use the Tukisha We Pay Rewards Mobile Application on a device other than the Authorised Device; (iv) take any action to circumvent, compromise or defeat any security measures implemented in the Tukisha Mobile Application; (v) use the Tukisha We Pay Rewards Mobile Application to access, copy, transfer, retransmit or transcode Content (as defined below) or any other content in violation of any law or third party rights; (vi) remove, obscure, or alter Tukisha's (or any third party's) copyright notices, trademarks, or other proprietary rights notices affixed to or contained within or accessed through the Tukisha Mobile Application.\n" +
                "7.2\tContent made available through the Tukisha We Pay Rewards Mobile Application (\"Content\") is protected by applicable intellectual property rights and is the sole property of Tukisha, its third party licensors and partners (as applicable), and other entities that provide such content to Tukisha. You may not (or enable others to) copy, distribute, display, modify, or otherwise use the Content of the Tukisha We Pay Rewards Mobile Application except as it is provided to You through the Tukisha Mobile Application. Tukisha and its licensors make no representations or warranties, in any respect whatsoever, regarding the accuracy or completeness of the Content.\n" +
                "\n"+
                "8.\tTERMINATION\n" +
                "You may terminate this Agreement at any time by permanently deleting the Tukisha We Pay Rewards Mobile Application in its entirety from the Authorised Device, whereupon (and without notice from Tukisha) any rights granted to You herein will automatically terminate. If You fail to comply with any provision of this Agreement, any rights granted to You herein will automatically and forthwith terminate. In the event of such termination, You must immediately delete the Tukisha We Pay Rewards Mobile Application from the Authorised Device.\n" +
                "\n"+
                "9.\tINDEMNITY\n" +
                "You, by accepting these terms and conditions, agree to hold harmless and indemnify Tukisha and its subsidiaries, affiliates, officers, agents, and employees (and their subsidiaries, affiliates, officers, agents, and employees) from and against any claim, suit or action arising from or in any way related to Your use of the Tukisha We Pay Rewards Mobile Application or Your violation of this Agreement, including any liability or expense arising from all claims, losses, damages, suits, judgments, litigation costs and attorneys' fees, of every kind and nature. In such a case, Tukisha will provide You with written notice of such claim, suit or action.\n" +
                "10.\tDISCLAIMER OF WARRANTIES\n" +
                "10.1\tThe Tukisha We Pay Rewards Mobile Application is provided on an \"as is\" basis and without warranty or representation of any kind. To the maximum extent permitted by law, Tukisha expressly disclaims all warranties and conditions of any kind, whether express or implied, including, but not limited to, the implied warranties and conditions of merchantability, fitness and/or information, technical or otherwise, for a particular purpose and non-infringement.\n" +
                "10.2\tYour use of the Tukisha We Pay Rewards Mobile Application is at your sole and entire risk. Tukisha shall not be obligated to provide you with any maintenance or support services in connection with the Tukisha Mobile Application.\n" +
                "10.3\tTukisha makes no warranty: - (i) that the Tukisha We Pay Rewards Mobile Application will meet your requirements; (ii) that the Tukisha We Pay Rewards Mobile Application will be error-free; (iii) regarding the security, reliability, timeliness, or performance of the Tukisha Mobile Application; (iv) that any errors in the Tukisha We Pay Rewards Mobile Application will be corrected\n" +
                "10.4\tAlthough every effort shall be made to provide you with your token immediately upon purchase, Tukisha in no way warrants that the product which is offered on the Tukisha We Pay Rewards Mobile Application will be completely uninterrupted and error free. Accordingly, there may be a delay (time out) in the delivery of the token to you.\n" +
                "10.5\tAny content or material you download or otherwise obtain through the Tukisha We Pay Rewards Mobile Application is obtained at your own discretion and risk and used at your own discretion and risk. You will be solely responsible for any damage to your authorised device (or any other device) or any loss of data that may result from downloading any such content or material.\n" +
                "10.6\tThe Tukisha We Pay Rewards Mobile Application is not intended for use in any activities during which the failure of the Tukisha We Pay Rewards Mobile Application could lead to death, personal injury, or severe physical or environmental damage.\n" +
                "10.7\tNo advice or information, whether oral or written, obtained by you from Tukisha or through the Tukisha We Pay Rewards Mobile Application shall create any warranty, in any respect whatsoever, not expressly stated in these terms and conditions.\n" +
                "11.\tLIMITATION OF LIABILITY\n" +
                "You expressly understand and agree that Tukisha shall not be liable to you for any direct, indirect, incidental, special, consequential or exemplary damages, including but not limited to, damages for loss of profits, goodwill, use, data, information or other intangible losses (even if Tukisha has been advised of the possibility of such damages) resulting from:- (i) the use or the inability to use the Tukisha Mobile Application; (ii) the inability to use the Tukisha We Pay Rewards Mobile Application to access content or data; (iii) the cost of procurement of substitute goods or services; (iv) unauthorised access to or alteration of your transmissions or data; (v) any other matter relating to the Tukisha Mobile Application. The aforegoing limitations shall apply notwithstanding a failure of essential purpose of any limited remedy and to the fullest extent permitted by law.\n" +
                "\n"+
                "12.\tENTIRE AGREEMENT; REVISIONS TO AGREEMENT\n" +
                "Tukisha may, from time to time, modify this Agreement. Such modifications shall be effective as soon as the modified version of the \"Tukisha Prepaid Products Mobile Application Terms and Conditions\" is posted in the online application store or any other authorised Tukisha We Pay Rewards Mobile Application distribution location. You can determine when this Agreement was last revised by referring to the \"LAST UPDATED\" legend at the top of then-current version of the \"Tukisha Prepaid Products Mobile Application Terms and Conditions\" in the online application store or any other authorised Tukisha We Pay Rewards Mobile Application distribution location. Your use of the Tukisha We Pay Rewards Mobile Application following such changes constitutes Your acceptance of the revised version of the \"Tukisha Prepaid Products Mobile Application Terms and Conditions\" in the online application store or any other authorised Tukisha We Pay Rewards Mobile Application distribution location.\n" +
                "13.\tGOVERNING LAW AND DISPUTE RESOLUTION\n" +
                "13.1\tThese Terms and Conditions and our relationship and/or any dispute arising from or in connection with these Terms and Conditions shall be governed and interpreted in accordance with the laws of the Republic of South Africa.\n" +
                "13.2\tBy using the Tukisha We Pay Rewards Mobile Application you consent to the exclusive jurisdiction of the Courts and / or Arbitration Forums of the Republic of South Africa in respect of any disputes arising in connection with the Tukisha We Pay Rewards Mobile Application and/or your use of it or information or other contents on it. The purpose of this clause is to make South African law apply and to give South African courts and Arbitration Forums jurisdiction if you are based outside of South Africa.\n" +
                "13.3\tAny dispute in regard to the interpretation of or the effect of or the parties' respective rights and obligations under or a breach of or in regard to any matter dealt with by or arising out of the provisions of this agreement at any time arising between the parties, shall be decided by arbitration, at the instance of the aggrieved party, in the manner set out in this clause.\n" +
                "13.4\tThe said arbitration shall be held subject to the provisions of this paragraph:\n" +
                "13.4.1\tat Pretoria, Republic of South Africa at the election of the party calling for such arbitration;\n" +
                "13.4.2\tformally, under the Standard Procedure Rules for the time being, as issued by the Arbitration Foundation of the Republic of South Africa or otherwise in accordance with the provisions of the Arbitration Act No. 42 of 1965, as amended;\n" +
                "13.5\tThe arbitrator shall be if the question in issue is:\n" +
                "13.5.1\tprimarily an accounting matter, an independent chartered accountant of not less than 15 (fifteen) years standing agreed upon between the parties as such, or appointed by the President for the time being of the Gauteng branch of the South African Institute of Chartered Accountants;\n" +
                "13.5.2\tprimarily a legal matter, a practicing advocate of not less than 15 (fifteen) years standing agreed upon between the parties as such, or appointed by the President for the time being of the Gauteng Society of Advocates, failing which, the Chairman of the Association of Arbitrators of South Africa;\n" +
                "13.5.3\tany other matter, an independent person agreed upon between the parties and failing agreement as may be appointed by the Chairman of the Association of Arbitrators of South Africa.\n" +
                "13.6\tNothing in this clause limits Your right to approach any court, tribunal or forum of competent jurisdiction in terms of the CPA.\n" +
                "\n"+
                "14.\tINFORMATION\n" +
                "14.1\tFor the purposes of the Electronic Communications and Transactions Act 25 of 2002 (ECTA), Tukisha's information is as follows, which should be read in conjunction with its product descriptions and other terms and conditions contained on the Tukisha Mobile Application:\n" +
                "14.1.1\tFull name: Tukisha Prepaid (Pty) Ltd, a private company registered in South Africa with registration number 2015/020391/07\n" +
                "14.1.2\tMain business: Electrical Distributor & Online Distributor\n" +
                "14.1.3\tPhysical address for receipt of legal service: Tukisha – 13 Block B, Victoria link street, Route 21 Corporate Park, Irene – Centurion (marked for attention: Managing Director)\n" +
                "14.1.4\tDirectors: Jimmy Domingo, Malete Phasha, Buti Tlhoaele\n" +
                "14.1.5\tPhone number: +27 12 345 2395\n" +
                "14.1.6\tOfficial email address: Info@Tukisha.co.za\n" +
                "14.1.7\tPAIA: The manual published in terms of section 51 of the Promotion of Access to Information Act 2000 may be downloaded from here.\n" +
                "14.2\tPlease contact your Service Provider for any of the following queries:\n" +
                "14.2.1\tQueries relating to the charges on your token\n" +
                "14.2.2\tIf Your device is registered to the wrong name\n" +
                "14.2.3\tIf there is any problem with Your device or product supply\n" +
                "14.2.4\tIf Your device will not accept the token but the device number is correct (where relevant).\n" +
                "14.3\tShould you experience any problems with regard to purchasing tokens on the Tukisha We Pay Rewards Mobile Application, please contact Tukisha on support@tukisha.co.za  or support@wepayrewards.co.za . Tukisha‘s support policy is to only contact You on request. If you would prefer that Tukisha phone you, kindly email a \"please phone me request\" to support@tukisha.co.za or support@wepayrewards.co.za  and an agent will contact You. Alternatively, you can contact Tukisha on 0861 852 853, where you may speak to an agent.\n" +
                "\n" +
                "\n" +
                "15.\tMISCELLANEOUS PROVISIONS\n" +
                "This Agreement is the complete and exclusive statement of the agreements between the parties with respect to the subject matter hereof and supersedes all other communications or representations or agreements (whether oral, written or otherwise) relating thereto. The failure of either party at any time to require performance of any provision of this Agreement in no manner shall affect such party's right at a later time to enforce the same. No waiver by either party of any breach of this Agreement, whether by conduct or otherwise, in any one or more instances, shall be deemed to be, or construed as, a further or continuing waiver of any other such breach, or a waiver of any other breach of this Agreement. \n" +
                "If any provision of this Agreement shall to any extent be held invalid, illegal or unenforceable, the validity, legality and enforceability of the remaining provisions of this Agreement shall in no way be affected or impaired thereby and each such provision of this Agreement shall be valid and enforceable to the fullest extent permitted by law. In such case, this Agreement shall be reformed to the minimum extent necessary to correct any invalidity, illegality or unenforceability, while preserving to the maximum extent the rights and commercial expectations of the parties hereto, as expressed herein. \n" +
                "You agree that regardless of any statute or law to the contrary, any claim or cause of action arising out of or related to use of the Tukisha We Pay Rewards Mobile Application or this Agreement must be filed by You within one (1) year after such claim or cause of action arose or be forever barred. The section headings in this Agreement are for convenience only and have no legal or contractual effect.\n" +
                "PRIVACY POLICY\n" +

                "\n"+ "1.\tINTRODUCTION\n" +
                "1.1\tThis Privacy Policy forms part of the TERMS AND CONDITIONS RELATING TO THE TUKISHA PREPAID PRODUCTS MOBILE APPLICATION (\"the Terms and Conditions\") and accordingly words defined in the Terms and Conditions shall have the same meaning in this Policy, unless the context indicates otherwise.\n" +
                "1.2\tWe respect your privacy and will take reasonable measures to protect it, as more fully detailed below.\n" +
                "1.3\tShould you decide to register as a user on the Mobile Application, we may require You to provide us with personal information which includes but is not limited to –\n" +
                "1.3.1\tyour name and surname\n" +
                "1.3.2\tyour email address\n" +
                "1.3.3\tyour identity number\n" +
                "1.3.4\tyour mobile number.\n" +
                "1.4\tFurther to 1.3 above, the Mobile Application makes use of \" COOKIES\" to automatically collect information and data through the standard operation of the Internet servers. \"Cookies\" are small text files a Mobile Application can use (and which we may use) to recognise repeat users, facilitate the user's on-going access to and use of a Mobile Application and allow a Mobile Application to track usage behaviour and compile aggregate data that will allow the Mobile Application operator to improve the functionality of the Mobile Application and its content. \n" +
                "The type of information collected by cookies is not used to personally identify you. If you do not want information collected through the use of cookies, there is a simple procedure in most browsers that allows you to deny or accept the cookie feature. Please note that cookies may be necessary to provide you with certain features available on our Mobile Application and thus if you disable the cookies on your browser you may not be able to use those features and your access to our Mobile Application will therefore be limited. If you do accept a \"cookie\", you thereby consent to our use of any personal information collected by us using that cookie.\n" +
                "1.5\tYour personal information may be stored in the Republic of South Africa or any other country in which Tukisha or its third party service providers maintain facilities. By using the Mobile Application, you consent to the collection of your personal information and to any transfer of such information outside the Republic of South Africa.\n" +
                "1.6\tShould your personal information change, please inform us and provide us with updates to your personal information as soon as reasonably possible so as to ensure the accuracy of the information in our possession. Tukisha shall not be liable for any inaccuracies in the information should you fail to update your personal information when necessary.\n" +
                "1.7\tSubject to 1.8 below, we will not, without your express consent:\n" +
                "1.7.1\tuse your personal information for any purpose other than as set out below:\n" +
                "1.7.1.1\tin relation to the ordering, sale and delivery of prepaid products\n" +
                "1.7.1.2\tto contact you regarding current or new prepaid electricity services or any other goods offered by us or any of our divisions and/or partners (unless you have opted out from receiving marketing material from us)\n" +
                "1.7.1.3\tto inform you of new features, special offers and promotional competitions offered by us or any of our divisions and/or partners (unless you have opted out from receiving marketing material from us)\n" +
                "1.7.1.4\tto improve your experience on our Mobile Application by, inter alia, monitoring statistical non-personal browsing habits, and to transact with us\n" +
                "1.7.2\tdisclose your personal information to any third party other than as set out below:\n" +
                "1.7.2.1\tto our employees and/or third party service providers who assist us to interact with you via our Mobile Application, email or any other method, for the ordering of prepaid electricity services, and thus need to know your personal information in order to assist us to communicate with you properly and efficiently\n" +
                "1.7.2.2\tto our divisions and/or partners (including their employees and/or third party service providers) in order for them to interact directly with you via email or any other method for purposes of sending you marketing material regarding any current or new goods or services, new features, special offers or promotional items offered by them (unless you have opted out from receiving marketing material from us)\n" +
                "1.7.2.3\tto our suppliers in order for them to liaise directly with you in the event of you submitting a warranty claim regarding any prepaid electricity services you have purchased which requires their involvement.\n" +
                "1.8\tWe are entitled to use or disclose your personal information if such use or disclosure is required in order to comply with any applicable law, order of court or legal process served on us, or to protect and defend our rights or property.\n" +
                "1.9\tWe will ensure that all of our employees, third party service providers, divisions and partners (including their employees and third party service providers) having access to your personal information are bound by appropriate and legally binding confidentiality and non-use obligations in relation to your personal information.\n" +
                "1.10\tWe will –\n" +
                "1.10.1\ttreat your personal information as strictly confidential\n" +
                "1.10.2\ttake appropriate technical and organisational measures to ensure that your personal information is kept secure and is protected against unauthorised or unlawful processing, accidental loss, destruction or damage, alteration, disclosure or access\n" +
                "1.10.3\tprovide you with access to your personal information to view and/or update personal details\n" +
                "1.10.4\tpromptly notify you if we become aware of any unauthorised use, disclosure or processing of your personal information;\n" +
                "1.10.5\tprovide you with reasonable evidence of our compliance with our obligations under this policy on reasonable notice and request; and\n" +
                "1.10.6\tupon your request, promptly return or destroy any and all of your personal information in our possession or control, unless we are compelled by law to retain certain information.\n" +
                "1.11\tWe will not retain your personal information longer than the period for which it was originally needed, unless we are required by law to do so, or you consent to us retaining such information for a longer period.\n" +
                "1.12\tTukisha undertakes never to sell or make your personal information available to any third party other than as provided for in this policy, unless we are compelled to do so by law or where you have indicated that we may do so. In particular, in the event of a fraudulent online payment, Tukisha reserves the right to disclose relevant personal information for criminal investigation purposes or in line with any other legal obligation for disclosure of the personal information which may be required of it.\n" +
                "1.13\tWhilst we will do all things reasonably necessary to protect your rights of privacy, we cannot guarantee or accept any liability whatsoever for unauthorised or unlawful disclosures of your personal information, whilst in our possession, made by third parties who are not subject to our control, unless such disclosure is as a result of our gross negligence.\n" +
                "1.14\tIf you disclose your personal information to a third party, such as an entity which operates a Mobile Application linked to this Mobile Application or anyone other than Tukisha, TUKISHA SHALL NOT BE LIABLE FOR ANY LOSS OR DAMAGE, HOWSOEVER ARISING, SUFFERED BY YOU AS A RESULT OF THE DISCLOSURE OF SUCH INFORMATION TO THE THIRD PARTY. This is because we do not regulate or control how that third party uses your personal information. You should always ensure that you read the privacy policy of any third party.\n" +
                "\n"+
                "PAYMENT SECURITY POLICY\n" +
                "1.\tINTRODUCTION\n" +
                "1.1\tThis Payment Security Policy:\n" +
                "1.1.1\tapplies to Registered Users who have purchased prepaid products through the Tukisha Mobile Application\n" +
                "1.1.2\tforms part of the TERMS AND CONDITIONS RELATING TO THE TUKISHA PREPAID PRODUCTS MOBILE APPLICATION (\"the Terms and Conditions\") and accordingly words defined in the Terms and Conditions shall have the same meaning in this Policy, unless the context indicates otherwise.\n" +
                "\n"+
                "2.\tPAYMENT SECURITY\n" +
                "2.1\tOur payment gateways only use the strictest forms of encryption at checkout, namely 256bit Secure Socket Layers (SSL) and no credit card details are stored on the Tukisha Mobile Application.\n" +
                "2.2\t3D Secure validation and security pin procedures set by 3D Secure are required for you to transact with us over the internet.\n" +
                "What is 3D Secure?\n" +
                "3D Secure provides Visa and MasterCard cardholders with extra protection when purchasing online, and South African banks have now made this security step mandatory in order to protect you against the unauthorised use of your card for online transactions.\n" +
                "How does it work?\n" +
                "Already Registered: Once you've entered your credit card details, you will then be redirected to 3D Secure. You will be prompted with a screen requesting a one-time PIN (OTP) which is sent to your cell phone, or a PIN / password that you have chosen beforehand.\n" +
                "Not Registered: If you're a first-time e-commerce shopper, or your card has not been registered yet, you will be prompted with a screen asking you to register for 3D Secure. Simply follow the on-screen prompts, it's easy.\n" +
                "2.3\tTokenisation and secure vault, provides Visa and MasterCard cardholders with extra security on the Mobile Application when purchasing electricity. The cardholder’s details are stored in a secure vault by a Visa and MasterCard compliant Payment Service Provider against an encrypted token, as such no card details are stored on the Mobile Application.\n" +
                "\n";

        textView.setText(para);
        textView.setMovementMethod(new ScrollingMovementMethod());




        final View gohome = findViewById(R.id.TNC);
        gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(TandCActicity.this,RegisterActivity.class);
                startActivity(int1);
            }
        });


    }
}
