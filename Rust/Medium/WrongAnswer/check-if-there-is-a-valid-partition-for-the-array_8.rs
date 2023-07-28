impl Solution {
    pub fn valid_partition(nums: Vec<i32>) -> bool {
        
        let mut counts = vec![0; 1_000_001];
        for &num in &nums {
            counts[num as usize] += 1;
        }
        let mut cur = 0;
        let mut prev = 0;
        let mut prev_count = 0;
        for (i, &count) in counts.iter().enumerate() {
            if count == 0 {
                continue;
            }
            if cur == 0 {
                cur = count;
                prev = i;
                prev_count = count;
                continue;
            }
            if count == cur {
                if prev_count >= 2 {
                    return true;
                }
                prev = i;
                prev_count = count;
                continue;
            }
            if count == cur - 1 {
                if prev == i - 1 {
                    if prev_count >= 2 {
                        return true;
                    }
                    prev = i;
                    prev_count = count;
                    cur = count;
                    continue;
                }
            }
            return false;
        }
        prev_count >= 2
    }
}