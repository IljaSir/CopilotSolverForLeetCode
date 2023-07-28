impl Solution {
    pub fn get_averages(nums: Vec<i32>, k: i32) -> Vec<i32> {
        
        let mut avgs = vec![];
        let mut i = 0;
        let mut j = 0;
        let mut sum = 0;
        let mut c = 0;
        while j < nums.len() {
            if j - i > k as usize {
                sum -= nums[i];
                c -= 1;
                i += 1;
            }
            sum += nums[j];
            c += 1;
            j += 1;
            if j - i > k as usize {
                avgs.push(sum / c);
            } else {
                avgs.push(-1);
            }
        }
        avgs
    }
}