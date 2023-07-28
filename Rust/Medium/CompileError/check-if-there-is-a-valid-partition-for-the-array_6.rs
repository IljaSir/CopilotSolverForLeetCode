impl Solution {
    pub fn valid_partition(nums: Vec<i32>) -> bool {
        
        let mut count = vec![0; 1000001];
        for &n in nums.iter() {
            count[n as usize] += 1;
        }
        let mut same = 0;
        let mut inc = 0;
        let mut last = -1;
        for i in 0..1000001 {
            if count[i] == 0 {
                continue;
            }
            if count[i] == 2 {
                same += 1;
                inc = 0;
                last = -1;
            } else if count[i] == 3 {
                if last == i - 1 {
                    inc += 1;
                    if inc == 2 {
                        return true;
                    }
                } else {
                    inc = 1;
                }
                last = i;
            } else {
                return false;
            }
        }
        same >= 2
    }
}