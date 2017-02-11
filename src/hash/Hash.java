package hash;


public class Hash {

    
    public static void main(String[] args) {
        String[] words = {"cat", "dog", "animal", "tac", "god", "act", "odd", "ogd"};
        String[] hashT = new String[13];
        for (String s:words){
            add(s,hashT);
        }
        System.out.println("---Hash Table---");
        System.out.println("Index   Word");
        int i = 0;
        for (String s:hashT){
            if (s==null)
                System.out.println(String.format("%4d", i) +  "   Empty");
            else
                System.out.println(String.format("%4d", i) + "   " + s);
            i++;
        }
        System.out.println(find("dog",hashT));
        System.out.println(find("puppy",hashT));
        System.out.println(find("ogd",hashT));
        
    }
    public static String find(String s, String[] hash){
        int a = hashfunc(s);
        if(hash[a].equals(s)){
            return "The word, " + s +", is found.";
        }
        else
            while(hash[a]!=null){
            if(a==hash.length)
                a = 0;
            a++;
            if(hash[a]==s)
                return "The word, " + s +", is found.";
            }
        return "The word, " + s +", isn't found.";
    }
    public static void add(String s, String[] hash){
        int a = hashfunc(s);
            if (hash[a]==null)
                hash[a] = s;
            else {
                while(hash[a]!=null){
                    a++;
                    if(a==12)
                        a = 0;
                }
                hash[a] = s;}
    }
    public static int hashfunc(String s){
        int a = 0;
        char[] characters = s.toCharArray();
        for (char i:characters){
            a += position(i);
        }
        return a%13;
    }
    public static int position(char letter){
        int a = letter - 'a' + 1;
        return a;
    }
}
