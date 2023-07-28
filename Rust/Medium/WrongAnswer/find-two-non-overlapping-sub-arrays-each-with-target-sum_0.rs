impl Solution {
    pub fn min_sum_of_lengths(arr: Vec<i32>, target: i32) -> i32 {
        
        let n = arr.len();
        let mut s = vec![0; n + 1];
        for i in 0..n {
            s[i + 1] = s[i] + arr[i];
        }
        let mut left = vec![n; n];
        let mut right = vec![n; n];
        let mut j = 0;
        let mut result = n;
        for i in 0..n {
            while j < n && s[j + 1] - s[i] <= target {
                j += 1;
            }
            if s[j] - s[i] == target {
                if i > 0 {
                    left[i] = left[i - 1];
                }
                left[i] = left[i].min(j - i);
            } else if i > 0 {
                left[i] = left[i - 1];
            }
        }
        let mut j = n;
        for i in (0..n).rev() {
            while j > 0 && s[i + 1] - s[j - 1] <= target {
                j -= 1;
            }
            if s[i + 1] - s[j] == target {
                if i < n - 1 {
                    right[i] = right[i + 1];
                }
                right[i] = right[i].min(i + 1 - j);
            } else if i < n - 1 {
                right[i] = right[i + 1];
            }
            if left[i] != n && right[i] != n {
                result = result.min(left[i] + right[i]);
            }
        }
        if result == n {
            -1
        } else {
            result as i32
        }
    }
}