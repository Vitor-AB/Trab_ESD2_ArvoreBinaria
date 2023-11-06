public class ArvoreBinaria {
        public No raiz;

        static class No {
            int valor;
            No filhoEsquerdo;
            No filhoDireito;

            public No(int valor) {
                this.valor = valor;
            }
        }

        public No inserir(int valor) {
            return this.inserir(new No(valor), raiz);
        }

        private No inserir(No novo, No anterior) {
            if (raiz == null) {
                raiz = novo;
                return raiz;
            }

            if (anterior != null) {
                if (novo.valor <= anterior.valor) {
                    anterior.filhoEsquerdo = this.inserir(novo, anterior.filhoEsquerdo);
                } else if (novo.valor > anterior.valor) {
                    anterior.filhoDireito = this.inserir(novo, anterior.filhoDireito);
                } else {
                    return null;
                }
            } else {
                anterior = novo;
            }

            return anterior;
        }

        public void treeWalk_EmOrdem(){
            this.treeWalk_EmOrdem(raiz);
        }

        private void treeWalk_EmOrdem(No no){
            if (no != null){
                System.out.print(no.valor + ", ");
                treeWalk_EmOrdem(no.filhoEsquerdo);
                treeWalk_EmOrdem(no.filhoDireito);
            }
        }

        public int intervaloWalk(int ini,int fin) {
            return this.intervaloWalk(raiz,ini,fin);
        }

        private int intervaloWalk(No no,int ini,int fin){
            if(no == null){
                return 0;
            }
            int soma = 0;

            if(no.valor >= ini && no.valor <= fin){
                soma += no.valor;
            }
            if(no.valor > ini) {
                soma += intervaloWalk(no.filhoEsquerdo, ini, fin);
            }

            if (no.valor < fin) {
                soma += intervaloWalk(no.filhoDireito, ini, fin);
            }

            return soma;
        }


    }

