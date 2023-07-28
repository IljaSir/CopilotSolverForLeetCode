impl Solution {
    pub fn odd_string(words: Vec<String>) -> String {
        
        let mut result = String::from("");
        let mut count = 0;
        let mut diff: Vec<i32> = Vec::new();
        for i in 0..words.len() {
            let mut temp: Vec<i32> = Vec::new();
            for j in 0..words[i].len() - 1 {
                temp.push(words[i].chars().nth(j + 1).unwrap() as i32 - words[i].chars().nth(j).unwrap() as i32);
            }
            if i == 0 {
                diff = temp;
            } else {
                if temp != diff {
                    count += 1;
                    result = words[i].clone();
                }
            }
        }
        result
    }
}