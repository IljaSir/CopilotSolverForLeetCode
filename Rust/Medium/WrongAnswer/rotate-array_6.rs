impl Solution {
    pub fn rotate(nums: &mut Vec<i32>, k: i32) {
        

        let k = k as usize;
        let n = nums.len();
        let k = k % n;
        if k == 0 {
            return;
        }
        let mut i = 0;
        let mut cur = nums[i];
        for _ in 0..n {
            let next = (i + k) % n;
            let tmp = nums[next];
            nums[next] = cur;
            cur = tmp;
            i = next;
        }
    }
}