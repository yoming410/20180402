//  資工系1B 106021153 郭又銘
import java.util.ArrayList;
import java.util.Scanner;
public class game_char {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> person = new ArrayList<>();
        String name;
        String sex;
        float attack_power;
        boolean bool = true;
        while (bool){
            System.out.println("\n *** 遊戲角色管理系統 ***\n==========================");
            System.out.println("1.新增角色");
            System.out.println("2.查詢角色");
            System.out.println("3.修改角色");
            System.out.println("4.刪除角色");
            System.out.println("5.角色總數");
            System.out.println("6.結    束");

            int function = sc.nextInt();
            switch (function){
                case 1:  //新增角色
                    System.out.print("角色名稱:\t");
                    name = sc.next();
                    System.out.print("性別:\t");
                    sex = sc.next();
                    System.out.print("攻擊力:\t");
                    attack_power = sc.nextFloat();

                    Person person1 = new Person(name,sex,attack_power);
                    person.add(person1);
                    break;
                case 2: //查詢角色
                    System.out.println("1.以角色名稱查詢");
                    System.out.println("2.以性別查詢");
                    System.out.println("3.以攻擊力查詢");
                    System.out.println("輸入其他鍵返回");
                    int function1 = sc.nextInt();
                    boolean have = false;
                    switch (function1){
                        case 1:
                            System.out.print("請輸入角色名稱:\t");
                            name = sc.next();
                            for (int i = 0;i < person.size() ;i++){
                                String x = person.get(i).getName();
                                if (x.equals(name)){
                                    have = true;
                                    System.out.println("角色名稱:" + person.get(i).getName());
                                    System.out.println("性別:" + person.get(i).getSex());
                                    System.out.println("攻擊力:" + person.get(i).getAttackPower());
                                }
                            }
                            if (!have){
                                System.out.println("找不到相關的角色");
                            }

                            break;

                        case 2:
                            System.out.print("請輸入性別:\t");
                            sex = sc.next();
                            for (int i = 0;i < person.size() ;i++){
                                String x = person.get(i).getSex();
                                if (x.equals(sex)){
                                    have = true;
                                    System.out.println("角色名稱:" + person.get(i).getName());
                                    System.out.println("性別:" + person.get(i).getSex());
                                    System.out.println("攻擊力:" + person.get(i).getAttackPower());
                                }
                            }
                            if (!have){
                                System.out.println("找不到相關的角色");
                            }
                            break;

                        case 3:
                            System.out.print("請輸入攻擊力:\t");
                            attack_power = sc.nextFloat();
                            for (int i = 0;i < person.size() ;i++){
                                float x = person.get(i).getAttackPower();
                                if (x == attack_power){
                                    have = true;
                                    System.out.println("角色:" + person.get(i).getName());
                                    System.out.println("性別:" + person.get(i).getSex());
                                    System.out.println("攻擊力:" + person.get(i).getAttackPower());
                                }
                            }
                            if (!have){
                                System.out.println("找不到相關的角色");
                            }
                            break;
                        default:
                            break;
                    }
                    break;

                case 3: //修改角色
                    System.out.println("要修改哪一位角色?");
                    String x = sc.next();
                    int index = 0;
                    for (int i = 0;i < person.size();i++){
                        if (person.get(i).name.equals(x)){
                            index = i;
                            break;
                        }
                    }
                    System.out.println("1.修改角色名稱");
                    System.out.println("2.修改性別");
                    System.out.println("3.修改攻擊力");
                    System.out.println("輸入其他鍵返回");
                    switch (sc.nextInt()){
                        case 1:
                            System.out.print("請輸入新的角色名稱:\t");
                            name = sc.next();
                            person.get(index).setName(name);
                            break;
                        case 2:
                            System.out.print("請輸入新的性別:\t");
                            sex = sc.next();
                            person.get(index).setSex(sex);
                            break;
                        case 3:
                            System.out.print("請輸入新的攻擊力:\t");
                            attack_power = sc.nextFloat();
                            person.get(index).setAttackPower(attack_power);
                        default:
                            break;
                    }
                    break;

                case 4: //刪除角色
                    System.out.println("要刪除哪一位角色?");
                    String y = sc.next();

                    for (int i = 0;i < person.size();i++){
                        if (person.get(i).name.equals(y)){
                            System.out.println("已刪除 "+person.get(i).name);
                            person.remove(person.get(i));
                            break;
                        }
                    }
                    break;

                case 5: //角色總數
                    System.out.println("系統現在有" + person.size() + "個角色");
                    break;

                case 6: //結    束
                    System.out.println("Bye-Bye!");
                    System.exit(0);
                    break;
                default:
                    bool = false;
                    break;
            }
        }
    }
}


class Person{
    String name;
    String sex;
    float attack_power;

    Person(String name,String sex,float attack_power){
        setName(name);
        setSex(sex);
        setAttackPower(attack_power);
    }


    public float getAttackPower() {
        return attack_power;
    }

    public void setAttackPower(float attack_power) {
        if (attack_power < 0){
            System.out.println("攻擊力不能為負值\t自動設定攻擊力為10");
            this.attack_power = 10;
        }else {
            this.attack_power = attack_power;
        }
    }

    public String getSex() {

        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}