import java.util.*;
public class DetectCycle {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }

    }

    public static void createGraph(ArrayList<Edge>graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));
        graph[0].add(new Edge(0,3,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,2,1));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,1,1));

        graph[3].add(new Edge(3,0,1));
        graph[3].add(new Edge(3,4,1));
        
        graph[4].add(new Edge(4,3,1));
    }

    public static boolean detectCylcle(ArrayList<Edge>[]graph){
        boolean vis[]= new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!vis[i]){
                if( detectCylcleUtil(graph, vis,i,-1)){
                    return true;
                }
                
            }
        }
        return false;
    }
    public static boolean detectCylcleUtil(ArrayList<Edge>[]graph,boolean vis[], int curr, int par){
        vis[curr]=true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e= graph[curr].get(i);
            //case-3
            if(!vis[e.dest] && detectCylcleUtil(graph,vis, e.dest, curr)){
                return true;
            }
            //case-1
            else if(vis[e.dest] && e.dest!=par){
                return true;
            }

            //case-2 do nothing continue
        }
        return false;
    }

    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge>graph[]= new ArrayList[V];
        createGraph(graph);
        System.out.println(detectCylcle(graph));
    }
}
