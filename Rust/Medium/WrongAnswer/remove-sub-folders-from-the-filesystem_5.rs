impl Solution {
    pub fn remove_subfolders(folder: Vec<String>) -> Vec<String> {
        
        let mut folder = folder;
        folder.sort();
        let mut res = vec![];
        let mut last = String::from("");
        for s in folder {
            if !s.starts_with(&last) || last.ends_with("/") && s[last.len()..].starts_with("/") {
                res.push(s.clone());
                last = s;
            }
        }
        res
    }
}