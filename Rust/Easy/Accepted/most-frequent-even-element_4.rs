impl Solution {
    pub fn most_frequent_even(nums: Vec<i32>) -> i32 {
        
        let mut count = vec![0; 100001];
        for n in nums {
            if n % 2 == 0 {
                count[n as usize] += 1;
            }
        }
        let mut max = 0;
        let mut ans = -1;
        for i in 0..100001 {
            if count[i] > max {
                ans = i as i32;
                max = count[i];
            }
        }
        ans
    }
}