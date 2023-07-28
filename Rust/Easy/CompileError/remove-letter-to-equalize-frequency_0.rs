impl Solution {
    pub fn equal_frequency(word: String) -> bool {
        
        let mut freq: Vec<i32> = vec![0; 26];
        for c in word.chars() {
            freq[(c as u8 - 'a' as u8) as usize] += 1;
        }
        let mut freqs = freq.iter().filter(|x| **x > 0).collect::<Vec<&i32>>();
        if freqs.len() == 1 {
            return true;
        }
        if freqs.len() == 2 {
            if freqs[0] == &1 || freqs[1] == &1 {
                return true;
            }
        }
        freqs.sort();
        let min = *freqs[0];
        let max = *freqs[freqs.len() - 1];
        if (max - min) == 1 {
            return freqs.iter().filter(|x| **x == min).count() == 1;
        }
        if min == 1 {
            return freqs.iter().filter(|x| **x == min).count() == 1;
        }
        false
    }
}