
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[T_Artikel](
	[Inventarnummer] [float] NOT NULL,
	[Personalnummer] [nchar](10) NULL,
	[Bezeichnung] [nchar](10) NULL,
	[Einkaufspreis] [nchar](10) NULL,
	[Typ] [nchar](10) NULL,
 CONSTRAINT [PK_T_Artikel] PRIMARY KEY CLUSTERED 
(
	[Inventarnummer] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


