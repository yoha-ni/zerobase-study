package dev.yoha_ni.study.month_02.week7.day1;

public class MatrixGraph{

    public static class ArrGraph {
        private int INF = 987654321;
        private int[][] arrGraph;

        public ArrGraph(int initSize) {
            this.arrGraph = new int[initSize + 1][initSize + 1];
        }

        public void put(int x, int y) {
            this.arrGraph[x][y] = arrGraph[y][x] = 1;
        }

        public void putSingle(int x, int y) {
            this.arrGraph[x][y] = 1;
        }

        public void printGraph() {
            for (int x = 1; x < arrGraph.length; x++) {
                for (int y = 1; y < arrGraph[x].length; y++) {
                    if (arrGraph[x][y] == 0) {
                        arrGraph[x][y] = INF;
                        System.out.print(" [" + arrGraph[x][y] + "]");
                    } else {
                        System.out.print(" [--------" + arrGraph[x][y] + "]");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        ArrGraph ag = new ArrGraph(10);
        ag.put(1, 5);
        ag.put(2, 5);
        ag.put(3, 5);
        ag.put(4, 5);
        ag.put(5, 5);
        ag.putSingle(7, 8);
        ag.printGraph();


//        final int INF = 987654321;
//
//        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(Arrays.asList(
//                new ArrayList<>(Arrays.asList(INF, 1, INF, 1, INF, INF, INF, INF)),
//                new ArrayList<>(Arrays.asList(INF, INF, 1, INF, 1, INF, INF, INF)),
//                new ArrayList<>(Arrays.asList(INF, 1, INF, INF, INF, INF, INF, INF)),
//                new ArrayList<>(Arrays.asList(INF, INF, INF, INF, 1, INF, 1, INF)),
//                new ArrayList<>(Arrays.asList(INF, INF, INF, INF, INF, 1, INF, INF)),
//                new ArrayList<>(Arrays.asList(INF, INF, INF, INF, INF, INF, INF, INF)),
//                new ArrayList<>(Arrays.asList(INF, INF, INF, INF, INF, INF, INF, 1)),
//                new ArrayList<>(Arrays.asList(INF, INF, INF, INF, INF, INF, INF, INF))
//        ));
//
//        for (int i = 0; i < graph.size(); i++) {
//            System.out.println(graph.get(i));
//        }

    }
}
