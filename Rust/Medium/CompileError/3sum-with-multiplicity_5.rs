impl Solution {
    pub fn three_sum_multi(arr: Vec<i32>, target: i32) -> i32 {
        
        let mut count = 0;
        let mut arr = arr;
        arr.sort();
        let n = arr.len();
        let mut i = 0;
        while i < n - 2 {
            let mut j = i + 1;
            let mut k = n - 1;
            while j < k {
                let sum = arr[i] + arr[j] + arr[k];
                if sum == target {
                    if arr[j] == arr[k] {
                        let diff = k - j + 1;
                        count = (count + diff * (diff - 1) / 2) % 1000000007;
                        break;
                    } else {
                        let mut left = 1;
                        while j + 1 < k && arr[j] == arr[j + 1] {
                            left += 1;
                            j += 1;
                        }
                        let mut right = 1;
                        while k - 1 > j && arr[k] == arr[k - 1] {
                            right += 1;
                            k -= 1;
                        }
                        count = (count + left * right) % 1000000007;
                        j += 1;
                        k -= 1;
                    }
                } else if sum < target {
                    j += 1;
                } else {
                    k -= 1;
                }
            }
            i += 1;
            while i < n - 2 && arr[i] == arr[i - 1] {
                i += 1;
            }
        }
        count
    }
}