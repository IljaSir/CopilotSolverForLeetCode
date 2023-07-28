impl Solution {
    pub fn smallest_number(pattern: String) -> String {
        
        let mut pattern = pattern.chars().collect::<Vec<char>>();
        let mut num = vec![];
        let mut i = 0;
        let mut j = pattern.len();
        for c in pattern {
            if c == 'I' {
                num.push(i);
                i += 1;
            } else {
                num.push(j);
                j -= 1;
            }
        }
        num.push(i);
        num.iter().map(|x| (x + 1).to_string()).collect()
    }
}