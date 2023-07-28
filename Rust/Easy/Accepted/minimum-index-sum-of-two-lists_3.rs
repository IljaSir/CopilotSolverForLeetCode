impl Solution {
    pub fn find_restaurant(list1: Vec<String>, list2: Vec<String>) -> Vec<String> {
        
        let mut res = vec![];
        let mut min = 2000;
        for i in 0..list1.len() {
            for j in 0..list2.len() {
                if list1[i] == list2[j] {
                    if i + j <= min {
                        if i + j < min {
                            min = i + j;
                            res.clear();
                        }
                        res.push(list1[i].to_string());
                    }
                }
            }
        }
        res
    }
}