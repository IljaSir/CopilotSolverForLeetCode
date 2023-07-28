impl Solution {
    pub fn original_digits(s: String) -> String {
        

        let mut counter = vec![0; 26];
        for c in s.chars() {
            counter[c as usize - 'a' as usize] += 1;
        }
        let mut res = Vec::new();
        let mut zero = counter['z' as usize - 'a' as usize];
        for _ in 0..zero {
            res.push('0');
        }
        let mut two = counter['w' as usize - 'a' as usize];
        for _ in 0..two {
            res.push('2');
        }
        let mut four = counter['u' as usize - 'a' as usize];
        for _ in 0..four {
            res.push('4');
        }
        let mut six = counter['x' as usize - 'a' as usize];
        for _ in 0..six {
            res.push('6');
        }
        let mut eight = counter['g' as usize - 'a' as usize];
        for _ in 0..eight {
            res.push('8');
        }
        let mut one = counter['o' as usize - 'a' as usize] - zero - two - four;
        for _ in 0..one {
            res.push('1');
        }
        let mut three = counter['h' as usize - 'a' as usize] - eight;
        for _ in 0..three {
            res.push('3');
        }
        let mut five = counter['f' as usize - 'a' as usize] - four;
        for _ in 0..five {
            res.push('5');
        }
        let mut seven = counter['s' as usize - 'a' as usize] - six;
        for _ in 0..seven {
            res.push('7');
        }
        let mut nine = counter['i' as usize - 'a' as usize] - five - six - eight;
        for _ in 0..nine {
            res.push('9');
        }
        res.sort();
        res.into_iter().collect()
    }
}