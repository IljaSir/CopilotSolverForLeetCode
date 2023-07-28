impl Solution {
    pub fn circular_array_loop(nums: Vec<i32>) -> bool {
        

        let mut nums = nums;
        for i in 0..nums.len() {
            if nums[i] == 0 {
                continue;
            }
            let mut slow = i;
            let mut fast = i;
            let mut dir = nums[i] > 0;
            loop {
                slow = Self::next(&nums, slow);
                fast = Self::next(&nums, fast);
                if fast == slow {
                    break;
                }
                if nums[fast] == 0 || dir != nums[fast] > 0 {
                    break;
                }
                fast = Self::next(&nums, fast);
                if fast == slow {
                    break;
                }
                if nums[fast] == 0 || dir != nums[fast] > 0 {
                    break;
                }
            }
            if slow == fast && slow != Self::next(&nums, slow) {
                return true;
            }
            let mut j = i;
            let val = nums[i];
            while nums[j] != 0 {
                let next = Self::next(&nums, j);
                nums[j] = 0;
                j = next;
            }
        }
        false
    }
    fn next(nums: &Vec<i32>, i: usize) -> usize {
        let n = nums.len();
        let mut next = i as i32 + nums[i];
        while next < 0 {
            next += n as i32;
        }
        (next as usize) % n
    }
}