public class Solution {
    public class Union{
        private int[] root;
        private int[] size;
        private int count;

        public Union(int capacity){
            this.root = new int[capacity];
            this.size = new int[capacity];
            for (int i = 0; i < capacity; i++) {
                root[i] = i;
                size[i] = 1;
            }

            this.count = capacity;
        }

        public int getCount() {return count;}

        public void connect(int p, int q){
            if (!isConnected(p, q)){
                int pRoot = findRoot(p);
                int qRoot = findRoot(q);
                if (size[qRoot] > size[pRoot]){
                    root[pRoot] = qRoot;
                    size[qRoot] += size[pRoot];
                }
                else {
                    root[qRoot] = pRoot;
                    size[pRoot] = size[qRoot];
                }
                count--;
            }
        }

        private boolean isConnected(int p, int q){
            return findRoot(p) == findRoot(q);
        }


        private int findRoot(int x){
            while (root[x] != x){
                //压缩
                root[x] = root[root[x]];
                x = root[x];
            }
            return x;
        }

    }

    public int findCircleNum(int[][] M) {
        int size = M.length;
        if (M.length == 0) return 0;

        Union union = new Union(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (M[i][j] == 1) union.connect(i, j);
            }
        }
        return union.getCount();
    }
}
