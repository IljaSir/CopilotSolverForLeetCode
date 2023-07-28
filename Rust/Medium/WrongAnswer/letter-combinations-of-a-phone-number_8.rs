impl Solution {
    pub fn letter_combinations(digits: String) -> Vec<String> {
        

        let mut result = vec![];
        let mut chars = vec![];
        for c in digits.chars() {
            chars.push(c);
        }
        let mut letters = vec![];
        for c in chars {
            let mut v = vec![];
            match c {
                '2' => {
                    v.push('a');
                    v.push('b');
                    v.push('c');
                }
                '3' => {
                    v.push('d');
                    v.push('e');
                    v.push('f');
                }
                '4' => {
                    v.push('g');
                    v.push('h');
                    v.push('i');
                }
                '5' => {
                    v.push('j');
                    v.push('k');
                    v.push('l');
                }
                '6' => {
                    v.push('m');
                    v.push('n');
                    v.push('o');
                }
                '7' => {
                    v.push('p');
                    v.push('q');
                    v.push('r');
                    v.push('s');
                }
                '8' => {
                    v.push('t');
                    v.push('u');
                    v.push('v');
                }
                '9' => {
                    v.push('w');
                    v.push('x');
                    v.push('y');
                    v.push('z');
                }
                _ => {}
            }
            letters.push(v);
        }
        if letters.len() == 0 {
            return result;
        }
        let mut i = 0;
        let mut j = 0;
        loop {
            let mut s = String::new();
            for k in 0..letters.len() {
                s.push(letters[k][j]);
            }
            result.push(s);
            j += 1;
            if j == letters[i].len() {
                i += 1;
                j = 0;
                if i == letters.len() {
                    break;
                }
            }
        }
        result
    }
}