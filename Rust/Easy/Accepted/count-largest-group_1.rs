impl Solution {
    pub fn count_largest_group(n: i32) -> i32 {
        
        let mut count = vec![0; 37];
        for i in 1..=n {
            let mut sum = 0;
            let mut j = i;
            while j > 0 {
                sum += j % 10;
                j /= 10;
            }
            count[sum as usize] += 1;
        }
        let mut max = 0;
        let mut ans = 0;
        for i in 1..=36 {
            if count[i] > max {
                max = count[i];
                ans = 1;
            } else if count[i] == max {
                ans += 1;
            }
        }
        ans
    }
}