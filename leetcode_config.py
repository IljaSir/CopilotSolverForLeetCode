import leetcode

class LeetcodeConfig:
    LEET_CODE_URL = 'https://leetcode.com'
    LEET_CODE_GRAPHQL_URL = 'https://leetcode.com/graphql'
    
    def __init__(self, leetcode_session, csrf_token) -> None:
        self.configuration = leetcode.Configuration()
        self.configuration.api_key["x-csrftoken"] = csrf_token
        self.configuration.api_key["csrftoken"] = csrf_token
        self.configuration.api_key["LEETCODE_SESSION"] = leetcode_session
        self.configuration.api_key["Referer"] = "https://leetcode.com"
        self.configuration.debug = False
        
        self.api_instance = leetcode.DefaultApi(leetcode.ApiClient(self.configuration))
        
    def get_current_user_status(self):
        graphql_request = leetcode.GraphqlQuery(
        query="""
            {
            user {
                    username
                    isCurrentUserPremium
                }
            }
            """,
        variables=leetcode.GraphqlQueryVariables(),
        )
        return self.api_instance.graphql_post(body=graphql_request)
    
    def get_problem_content(self, problem_name):
        graphql_request = leetcode.GraphqlQuery(
            query="""
            {
                question(titleSlug: "%s") {
                    content
                    questionId
                    questionFrontendId
                    codeSnippets {
                        lang
                        langSlug
                        code
                    }
                    envInfo
                    enableRunCode
                }
            }
            """ % problem_name,
            variables=leetcode.GraphqlQueryVariables(),
        )
        return self.api_instance.graphql_post(body=graphql_request)