impl Solution {
    pub fn three_sum_multi(arr: Vec<i32>, target: i32) -> i32 {
        
        let mut arr = arr;
        arr.sort();
        let mut res = 0;
        for i in 0..arr.len() {
            let mut j = i + 1;
            let mut k = arr.len() - 1;
            while j < k {
                if arr[i] + arr[j] + arr[k] < target {
                    j += 1;
                } else if arr[i] + arr[j] + arr[k] > target {
                    k -= 1;
                } else {
                    if arr[j] != arr[k] {
                        let mut left = 1;
                        let mut right = 1;
                        while j + 1 < k && arr[j] == arr[j + 1] {
                            left += 1;
                            j += 1;
                        }
                        while k - 1 > j && arr[k] == arr[k - 1] {
                            right += 1;
                            k -= 1;
                        }
                        res += left * right;
                        res %= 1000000007;
                        j += 1;
                        k -= 1;
                    } else {
                        res += (k - j + 1) * (k - j) / 2;
                        res %= 1000000007;
                        break;
                    }
                }
            }
        }
        res as i32
    }
}