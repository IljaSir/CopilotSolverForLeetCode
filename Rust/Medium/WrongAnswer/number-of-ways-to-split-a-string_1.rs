impl Solution {
    pub fn num_ways(s: String) -> i32 {
        
        let s: Vec<char> = s.chars().collect();
        let n = s.len();
        let mut ones = 0;
        for i in 0..n {
            if s[i] == '1' {
                ones += 1;
            }
        }
        if ones % 3 != 0 {
            return 0;
        }
        if ones == 0 {
            return ((n - 1) as i64 * (n - 2) as i64 / 2 % 1000000007) as i32;
        }
        let mut i = 0;
        let mut j = 0;
        let mut k = 0;
        let mut count = 0;
        while i < n {
            if s[i] == '1' {
                count += 1;
                if count == ones/3 {
                    j = i + 1;
                    break;
                }
            }
            i += 1;
        }
        while j < n {
            if s[j] == '1' {
                count += 1;
                if count == 2*ones/3 {
                    k = j + 1;
                    break;
                }
            }
            j += 1;
        }
        let mut count1 = 0;
        let mut count2 = 0;
        while i < n {
            if s[i] == '1' {
                break;
            }
            i += 1;
            count1 += 1;
        }
        while j < n {
            if s[j] == '1' {
                break;
            }
            j += 1;
            count2 += 1;
        }
        ((count1 + 1) * (count2 + 1) % 1000000007) as i32
    }
}