impl Solution {
    pub fn valid_partition(nums: Vec<i32>) -> bool {
        
        let mut freq = vec![0; 1_000_001];
        for &n in nums.iter() {
            freq[n as usize] += 1;
        }
        let (mut two, mut three, mut inc) = (0, 0, 0);
        for i in 0..1_000_001 {
            if freq[i] == 0 {
                continue;
            }
            if freq[i] == 2 {
                two += 1;
            } else if freq[i] == 3 {
                three += 1;
            } else if freq[i] > 3 {
                return false;
            }
            if i > 0 && freq[i - 1] > 0 {
                inc += 1;
            }
        }
        two == 0 && three == 0 || two == 0 && three == 1 || two == 1 && three == 0 || inc == two + three
    }
}