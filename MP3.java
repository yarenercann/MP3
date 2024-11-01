
import java.time.temporal.Temporal;
import java.util.Scanner;
import javax.swing.SizeRequirements;


public class MP3 {
    Sarki head;
    
    public void ekle(String ad,String sanatci,String tur,int sure){
        Sarki yeni=new Sarki(ad,sanatci,tur,sure);
        if(head==null)
        {
            head=yeni;
        }
        else{
            Sarki temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=yeni;
        }
        System.out.println(ad+" sarkisi eklenmistir.");
    }
    
    public void sil(String ad)
    {
        if(head==null)
        {
            System.out.println("Listede sarki bulunamamistir.");
        }
        else {
            Sarki temp=head;
            while(temp.next != null ){
                if(temp.next.ad.equals(ad))
                {
                    temp.next=temp.next.next;
                    System.out.println(ad+" sarkisi silinmistir.");
                }
                temp=temp.next;
            }
        }
    }
    
    public void sarkiAdinaGore(){
        System.out.println("Sarki adina gore caliniyor.");
        Sarki temp=head;
        while(temp !=null)
        {
            cal(temp);
            temp=temp.next;
        }
    }
    
    public void sanatciyaGore()
    {
        System.out.println("Sanatciya gore caliniyor.");
        Sarki temp=head;
        while(temp != null)
        {
            cal(temp);
            temp=temp.next;
        }
    }
    
    public void tureGore()
    {
        System.out.println("Sarki turune gore caliniyor.");
        Sarki temp=head;
        while(temp != null)
        {
            cal(temp);
            temp=temp.next;
        }
    }
    
    public void sureyeGore()
    {
        System.out.println("Sureye gore caliniyor.");
        Sarki temp=head;
        while(temp != null)
        {
            cal(temp);
            temp=temp.next;
        }
    }

    
    public void rastgele() {
        System.out.println("Rastgele sarki caliniyor.");
        Sarki temp=head;
        int sayac=0;
        while(temp !=null){
            sayac++;
            temp=temp.next;
        }
        
        Random rastgele=new Random();
        int index=rastgele.nextInt(sayac);
        temp=head;
        for(int i=0;i<index;i++)
        {
            temp=temp.next;
        }
        cal(temp);
    }
    
    
    private void cal(Sarki sarki){
        System.out.println("Sarki caliniyor -> "+sarki.ad+" - "+sarki.sanatci+" ( "+sarki.tur+" )");
        try {
            Thread.sleep(5000); 
        } catch (Exception e) {
            System.out.println(e);;
        }
    }
    public void menu()
    {  
    Scanner scanner =new Scanner(System.in);
    int secim;    
        
        do{
         System.out.println("MP3 Calar Menusu:\n");
        System.out.println("1.Sarki Ekle");
        System.out.println("2.Sarki Sil");
        System.out.println("3.Sarki Adina Gore Cal");
        System.out.println("4.Sanatciya Gore Cal");
        System.out.println("5.Sarki Turune Gore Cal");
        System.out.println("6.Sureye Gore Cal");
        System.err.println("7.Rastgele Cal");
        System.out.println("0. Cikis");
        
        System.out.println("Seciminiz: ");
        secim=scanner.nextInt();
        
        scanner.nextLine();
        
        switch(secim)
        {
            case 1:
                System.out.println("Sarki Adi:");
                String ad=scanner.nextLine();
                System.out.println("Sanatci Adi:");
                String sanatci=scanner.nextLine();
                System.out.println("Sarki Turu:");
                String tur=scanner.nextLine();
                System.out.println("Sure:");
                int sure=scanner.nextInt();
                scanner.nextLine();
                ekle(ad, sanatci, tur, sure);
                break;

            case 2:
                System.out.println("Silinecek Sarki:");
                String silinecek=scanner.nextLine();
                sil(silinecek);
                break;
            case 3:
                sarkiAdinaGore();
                break;
            case 4:
                sanatciyaGore();
                break;
            case 5:
                tureGore();
                break;
            case 6:
                sureyeGore();
                break;
            case 7:
                rastgele();
                break;
            case 0:
                System.out.println("Menuden cikis yapiliyor.");
                scanner.close();
                return;
            default:
                System.out.println("Gecersiz secimi girdiniz.Tekrar deneyiniz.");
        }
    }while(secim!=0);
        
    }
    
}
