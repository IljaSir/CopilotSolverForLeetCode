impl Solution {
    pub fn can_eat(candies_count: Vec<i32>, queries: Vec<Vec<i32>>) -> Vec<bool> {
        
        let mut result = Vec::new();
        let mut sum = Vec::new();
        let mut count = 0;
        for i in 0..candies_count.len() {
            count += candies_count[i];
            sum.push(count);
        }
        for q in queries {
            let (t, d, c) = (q[0] as usize, q[1], q[2]);
            let min = d + 1;
            let max = (d + 1) * c;
            let mut left = 0;
            let mut right = sum.len() - 1;
            let mut mid = 0;
            while left <= right {
                mid = (left + right) / 2;
                if sum[mid] > t {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            let mut left = 0;
            let mut right = sum.len() - 1;
            let mut mid = 0;
            while left <= right {
                mid = (left + right) / 2;
                if sum[mid] > t + 1 {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (min <= sum[mid] && max >= sum[mid - 1]) {
                result.push(true);
            } else {
                result.push(false);
            }
        }
        result
    }
}