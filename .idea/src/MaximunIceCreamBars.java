class MaximunIceCreamBars {
    public void merge(int[] arr, int[] temp, int low, int high) {
        int mid = (low + high) / 2;
        int i = low;
        int j = mid + 1;
        int k = 0;
        int total = high - low + 1;

        while (k < total) {
            if (i > mid) {
                temp[k] = arr[j];
                j++;
            } else if (j > high) {
                temp[k] = arr[i];
                i++;
            } else if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        for (int l = 0; l < total; l++) {
            arr[l + low] = temp[l];
        }

    }

    public void mergeSort(int[] arr, int[] temp, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;
        mergeSort(arr, temp, low, mid);
        mergeSort(arr, temp, mid + 1, high);
        merge(arr, temp, low, high);
    }

    public void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
    }

    public int maxIceCream(int[] costs, int coins) {
        mergeSort(costs);

        int sum = 0;
        if (coins < costs[0]) {
            return 0;
        }
        for (int i = 0; i < costs.length; i++) {
            sum += costs[i];
            System.out.println(sum + " " + coins);
            if (sum > coins) {
                return i;
            }
        }

        return costs.length;
    }
}