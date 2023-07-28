impl Solution {
    pub fn min_swaps(nums: Vec<i32>) -> i32 {
        
        let mut n = nums.len();
        let mut c = nums.iter().filter(|&&x| x == 1).count();
        let mut i = 0;
        let mut j = c;
        let mut k = nums.iter().filter(|&&x| x == 1).take(c).collect::<Vec<_>>();
        let mut ans = n - c;
        while j < n {
            if k[i] == &1 {
                ans -= 1;
            }
            i += 1;
            k.push(&nums[j]);
            j += 1;
        }
        ans as i32
    }
}