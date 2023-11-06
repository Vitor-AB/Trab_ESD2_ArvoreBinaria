public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        int[] lista = new int[]{1,2,3,6,8,25,14,35};
        for (int i:
             lista) {
            arvore.inserir(i);
        }

        arvore.treeWalk_EmOrdem();

        int ini = 3;
        int fin = 25;

        System.out.println("\nA Soma dos intervalos [" + ini + "," + fin  + "] é: " + arvore.intervaloWalk(ini,fin));
    }
}
