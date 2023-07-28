impl Solution {
    pub fn min_operations(nums: Vec<i32>, queries: Vec<i32>) -> Vec<i64> {
        
        let mut num = vec![0; 100001];
        let mut sum = vec![0; 100002];
        for n in nums {
            num[n as usize] += 1;
        }
        for i in 1..=100000 {
            sum[i] = sum[i - 1] + num[i];
        }
        let mut ans = vec![];
        for q in queries {
            let mut left = 1;
            let mut right = 100000;
            let mut mid = (left + right) / 2;
            while left < right {
                if sum[mid] < q {
                    left = mid + 1;
                } else {
                    right = mid;
                }
                mid = (left + right) / 2;
            }
            let mut l = mid - 1;
            let mut r = mid + 1;
            let mut res = 0;
            while l >= 1 || r <= 100000 {
                if l >= 1 {
                    if sum[l] >= q {
                        res += (sum[l] - q) * (mid - l) as i64;
                        break;
                    }
                    l -= 1;
                }
                if r <= 100000 {
                    if sum[r] >= q {
                        res += (q - sum[r - 1]) * (r - mid) as i64;
                        break;
                    }
                    r += 1;
                }
            }
            ans.push(res);
        }
        ans
    }
}