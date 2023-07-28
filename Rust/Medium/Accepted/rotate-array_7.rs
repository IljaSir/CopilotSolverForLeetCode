impl Solution {
    pub fn rotate(nums: &mut Vec<i32>, k: i32) {
        

        let mut k = k;
        let n = nums.len();
        let mut count = 0;
        for i in 0..n {
            if count == n {
                return;
            }
            let mut cur = i;
            let mut prev = nums[i];
            loop {
                let next = (cur + k as usize) % n;
                let temp = nums[next];
                nums[next] = prev;
                prev = temp;
                cur = next;
                count += 1;
                if i == cur {
                    break;
                }
            }
        }
    }
}