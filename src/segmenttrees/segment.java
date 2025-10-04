package src.segmenttrees;

public class segment {
    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static void buildt(int i, int si, int sj, int arr[]) {
        if (si == sj) {
            tree[i] = arr[si];
            return;
        }
        int mid = (si + sj) / 2;
        buildt(2 * i + 1, si, mid, arr);
        buildt(2 * i + 2, mid + 1, sj, arr);
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }

    public static int sumUtil(int i, int si, int sj, int qi, int qj) {
        if (si > qj || sj < qi) {// non overlapping case
            return 0;
        } else if (si >= qi && sj <= qj) {// complete
            return tree[i];

        } else {
            int mid = (si + sj) / 2;
            int left = sumUtil(2 * i + 1, si, mid, qi, qj);
            int right = sumUtil(2 * i + 2, mid + 1, sj, qi, qj);
            return left + right;

        }
    }

    public static int sum(int arr[], int qi, int qj) {
        int n = arr.length;
        return sumUtil(0, 0, n - 1, qi, qj);
    }

    public static void updateutil(int i, int si, int sj, int idx, int diff) {
        if (idx < si || idx > sj) {
            return;
        }
        tree[i] += diff;
        if (si != sj) {
            int mid = (si + sj) / 2;
            updateutil(2 * i + 1, i, mid, idx, diff);
            updateutil(2 * i + 2, mid + 1, sj, idx, diff);
        }
    }

    public static void update(int arr[], int idx, int newval) {
        int n = arr.length;
        int diff = newval - arr[idx];
        arr[idx] = newval;
        updateutil(0, 0, n - 1, idx, diff);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 5, 7, 8, 6 };
        int n = arr.length;
        init(n);
        buildt(0, 0, n - 1, arr);
        System.out.println(sum(arr, 0, 3));
        update(arr, 2, 0);
        System.out.println(sum(arr, 0, 3));

    }

}
