impl Solution {
    pub fn three_sum_multi(arr: Vec<i32>, target: i32) -> i32 {
        
        let mut count = 0;
        let mut arr = arr;
        arr.sort();
        let n = arr.len();
        let modulo = 1_000_000_007;
        for i in 0..n - 2 {
            let mut left = i + 1;
            let mut right = n - 1;
            while left < right {
                let sum = arr[i] + arr[left] + arr[right];
                if sum > target {
                    right -= 1;
                } else if sum < target {
                    left += 1;
                } else {
                    if arr[left] != arr[right] {
                        let mut left_count = 1;
                        let mut right_count = 1;
                        while left + 1 < right && arr[left] == arr[left + 1] {
                            left_count += 1;
                            left += 1;
                        }
                        while right - 1 > left && arr[right] == arr[right - 1] {
                            right_count += 1;
                            right -= 1;
                        }
                        count += left_count * right_count;
                        count %= modulo;
                        left += 1;
                        right -= 1;
                    } else {
                        let left_count = right - left + 1;
                        count += left_count * (left_count - 1) / 2;
                        count %= modulo;
                        break;
                    }
                }
            }
        }
        count
    }
}