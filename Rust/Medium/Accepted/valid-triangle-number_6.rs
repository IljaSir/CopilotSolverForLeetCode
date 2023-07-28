impl Solution {
    pub fn triangle_number(nums: Vec<i32>) -> i32 {
        

        let mut nums = nums;
        nums.sort();
        let mut ans = 0;
        for i in 0..nums.len() {
            for j in i+1..nums.len() {
                let mut l = j + 1;
                let mut r = nums.len();
                while l < r {
                    let mid = (l + r) / 2;
                    if nums[mid] < nums[i] + nums[j] {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                ans += l - j - 1;
            }
        }
        ans as i32
    }
}