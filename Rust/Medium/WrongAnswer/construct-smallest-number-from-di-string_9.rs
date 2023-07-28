impl Solution {
    pub fn smallest_number(pattern: String) -> String {
        
        let mut v: Vec<u8> = vec![];
        let mut dec = 9;
        let mut inc = 1;
        let mut last = ' ';
        for c in pattern.chars() {
            if c == 'I' {
                if last == 'I' {
                    v.push(inc);
                    inc += 1;
                } else {
                    v.push(inc);
                    inc += 1;
                    v.push(inc);
                    inc += 1;
                }
            } else {
                if last == 'D' {
                    v.push(dec);
                    dec -= 1;
                } else {
                    v.push(dec);
                    dec -= 1;
                    v.push(dec);
                    dec -= 1;
                }
            }
            last = c;
        }
        if last == 'I' {
            v.push(inc);
        } else {
            v.push(dec);
        }
        String::from_utf8(v).unwrap()
    }
}